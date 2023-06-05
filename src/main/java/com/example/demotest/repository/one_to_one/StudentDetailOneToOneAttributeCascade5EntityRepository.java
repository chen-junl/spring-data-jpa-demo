package com.example.demotest.repository.one_to_one;

import com.example.demotest.entity.one_to_one.attribute.cascade.StudentDetailOneToOneAttributeCascade5Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailOneToOneAttributeCascade5EntityRepository extends JpaRepository<StudentDetailOneToOneAttributeCascade5Entity, Integer> {
}