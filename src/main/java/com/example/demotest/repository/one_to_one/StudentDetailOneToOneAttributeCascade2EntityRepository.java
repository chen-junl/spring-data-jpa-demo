package com.example.demotest.repository.one_to_one;

import com.example.demotest.entity.one_to_one.attribute.cascade.StudentDetailOneToOneAttributeCascade2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailOneToOneAttributeCascade2EntityRepository extends JpaRepository<StudentDetailOneToOneAttributeCascade2Entity, Integer> {
}