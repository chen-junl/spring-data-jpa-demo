package com.example.demotest.repository.many_to_many;

import com.example.demotest.entity.many_to_many.type1.StudentManyToManyType1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentManyToManyType1EntityRepository extends JpaRepository<StudentManyToManyType1Entity, Integer> {
}