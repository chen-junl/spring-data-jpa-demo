package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.type1.StudentOneToManyType1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToManyType1EntityRepository extends JpaRepository<StudentOneToManyType1Entity, Integer> {
}