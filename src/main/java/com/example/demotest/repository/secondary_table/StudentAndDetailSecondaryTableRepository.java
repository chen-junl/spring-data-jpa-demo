package com.example.demotest.repository.secondary_table;

import com.example.demotest.base.BaseRepository;
import com.example.demotest.entity.secondary_table.StudentAndDetailSecondaryTableEntity;
import org.springframework.stereotype.Repository;

/**
 * @author chenjunl
 * @Description 表持久化
 * @date 2022-12-08 10:37:11
 */
@Repository
public interface StudentAndDetailSecondaryTableRepository extends BaseRepository<StudentAndDetailSecondaryTableEntity, Integer> {
}
