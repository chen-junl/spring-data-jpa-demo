package com.example.demotest.base;

import java.lang.reflect.ParameterizedType;

/**
 * @author chenjunl
 * @description
 * @date 2023/4/23
 */
public interface BaseSendMqService<T> {
    /**
     * 发送消息
     *
     * @param entity
     * @param method
     * @return
     */
    boolean sendMq(T entity, String method);

    /**
     * 获取当前接口的泛型类型
     *
     * @return
     */
    default Class<T> getEntityClass() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericInterfaces()[0];
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }
}



