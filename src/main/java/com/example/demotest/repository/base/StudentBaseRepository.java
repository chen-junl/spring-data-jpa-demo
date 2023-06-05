package com.example.demotest.repository.base;

import com.example.demotest.base.BaseRepository;
import com.example.demotest.entity.StudentEntity;
import org.springframework.stereotype.Repository;

/**
 * @author chenjunl
 * @Description 表持久化
 * @date 2022-12-08 10:37:11
 */
@Repository
public interface StudentBaseRepository extends BaseRepository<StudentEntity, Integer> {
}
