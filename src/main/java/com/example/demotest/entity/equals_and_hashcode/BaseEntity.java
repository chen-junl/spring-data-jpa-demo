package com.example.demotest.entity.equals_and_hashcode;

import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
public class BaseEntity {
    /**
     * 主键自增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

}