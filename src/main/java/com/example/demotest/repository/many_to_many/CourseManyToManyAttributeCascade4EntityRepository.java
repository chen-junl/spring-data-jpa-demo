package com.example.demotest.repository.many_to_many;

import com.example.demotest.entity.many_to_many.attribute.cascade.CourseManyToManyAttributeCascade4Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseManyToManyAttributeCascade4EntityRepository extends JpaRepository<CourseManyToManyAttributeCascade4Entity, Integer> {
}