package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.attribute.cascade.StudentOneToManyAttributeCascade4Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToManyAttributeCascade4EntityRepository extends JpaRepository<StudentOneToManyAttributeCascade4Entity, Integer> {
}