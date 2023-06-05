package com.example.demotest.repository.one_to_one;

import com.example.demotest.entity.one_to_one.type1.StudentDetailOneToOneType1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailOneToOneType1EntityRepository extends JpaRepository<StudentDetailOneToOneType1Entity, Integer> {
}