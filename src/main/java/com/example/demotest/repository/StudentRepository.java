package com.example.demotest.repository;

import com.example.demotest.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chenjunl
 * @Description 表持久化
 * @date 2022-12-08 10:37:11
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
