package com.example.demotest.repository.many_to_many;

import com.example.demotest.entity.many_to_many.attribute.CourseManyToManyAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseManyToManyAttributeEntityRepository extends JpaRepository<CourseManyToManyAttributeEntity, Integer> {
}