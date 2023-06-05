package com.example.demotest.repository.many_to_many;

import com.example.demotest.entity.many_to_many.type1.CourseManyToManyType1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseManyToManyType1EntityRepository extends JpaRepository<CourseManyToManyType1Entity, Integer> {
}