package com.example.demotest.base.impl;

import com.example.demotest.base.BaseRepository;
import com.example.demotest.base.BaseSendMqService;
import com.example.demotest.base.BeanUtil;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author chenjunl
 * @description
 * @date 2023/4/23
 */
public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private final JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager em;

    private final Map<Class<T>, BaseSendMqService> baseSendMqServiceList;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.em = entityManager;
        this.baseSendMqServiceList = BeanUtil.getBeansOfType(BaseSendMqService.class).values().stream().collect(Collectors.toMap(BaseSendMqService::getEntityClass, Function.identity()));
    }


    /**
     * spring默认将非insert* update* delete*开头的方法 设置为只读,必须修改为readOnly = false才能执行save方法
     *
     * @param entity
     * @param <S>
     * @return
     * @see org.springframework.transaction.interceptor.TransactionProxyFactoryBean
     */
    @Override
    @Transactional(readOnly = false)
    public <S extends T> S saveWithMq(S entity) {
        String method = entityInformation.isNew(entity) ? "ADD" : "UPDATE";
        S result = super.save(entity);
        if (null != this.baseSendMqServiceList) {
            BaseSendMqService baseSendMqService = this.baseSendMqServiceList.get(entity.getClass());
            if (null != baseSendMqService) {
                baseSendMqService.sendMq(entity, method);
            }
        }
        return result;
    }
}
