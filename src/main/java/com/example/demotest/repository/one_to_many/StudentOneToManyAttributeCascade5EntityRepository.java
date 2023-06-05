package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.attribute.cascade.StudentOneToManyAttributeCascade5Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToManyAttributeCascade5EntityRepository extends JpaRepository<StudentOneToManyAttributeCascade5Entity, Integer> {
}