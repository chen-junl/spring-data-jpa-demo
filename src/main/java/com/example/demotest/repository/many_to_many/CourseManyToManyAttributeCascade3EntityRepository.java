package com.example.demotest.repository.many_to_many;

import com.example.demotest.entity.many_to_many.attribute.cascade.CourseManyToManyAttributeCascade3Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseManyToManyAttributeCascade3EntityRepository extends JpaRepository<CourseManyToManyAttributeCascade3Entity, Integer> {
}