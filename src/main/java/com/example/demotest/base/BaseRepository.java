package com.example.demotest.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author chenjunl
 * @description
 * @date 2023/4/23
 */
@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID>, CrudRepository<T, ID> {
    /**
     * @param entity
     * @param <S>
     * @return
     */
    <S extends T> S saveWithMq(S entity);
}
