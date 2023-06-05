package com.example.demotest.repository.many_to_many;

import com.example.demotest.entity.many_to_many.type2.CourseManyToManyType2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseManyToManyType2EntityRepository extends JpaRepository<CourseManyToManyType2Entity, Integer> {
}