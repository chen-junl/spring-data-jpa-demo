package com.example.demotest.repository.one_to_one;

import com.example.demotest.entity.one_to_one.type1.StudentOneToOneType1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToOneType1EntityRepository extends JpaRepository<StudentOneToOneType1Entity, Integer> {
}