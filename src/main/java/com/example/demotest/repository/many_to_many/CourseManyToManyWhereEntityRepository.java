package com.example.demotest.repository.many_to_many;

import com.example.demotest.entity.many_to_many.where_join_table.CourseManyToManyWhereEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseManyToManyWhereEntityRepository extends JpaRepository<CourseManyToManyWhereEntity, Integer> {
}