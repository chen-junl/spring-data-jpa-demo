package com.example.demotest.repository.many_to_many;

import com.example.demotest.entity.many_to_many.attribute.cascade.CourseManyToManyAttributeCascade1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseManyToManyAttributeCascade1EntityRepository extends JpaRepository<CourseManyToManyAttributeCascade1Entity, Integer> {
}