package com.example.demotest.repository.many_to_one;

import com.example.demotest.entity.many_to_one.type1.StudentManyToOneType1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentManyToOneType1EntityRepository extends JpaRepository<StudentManyToOneType1Entity, Integer> {
}