package com.example.demotest.entity.equals_and_hashcode;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author chenjunl
 * @Description 通用字段实体
 * @date 2022-12-08 10:37:11
 */
@Getter
@Setter
@MappedSuperclass
public class BaseWithoutHashCodeEntity {
    /**
     * 主键自增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

}