package com.example.demotest.repository.many_to_many;

import com.example.demotest.entity.many_to_many.attribute.cascade.CourseManyToManyAttributeCascade2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseManyToManyAttributeCascade2EntityRepository extends JpaRepository<CourseManyToManyAttributeCascade2Entity, Integer> {
}