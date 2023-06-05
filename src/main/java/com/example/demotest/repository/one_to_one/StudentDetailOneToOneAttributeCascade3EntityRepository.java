package com.example.demotest.repository.one_to_one;

import com.example.demotest.entity.one_to_one.attribute.cascade.StudentDetailOneToOneAttributeCascade3Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailOneToOneAttributeCascade3EntityRepository extends JpaRepository<StudentDetailOneToOneAttributeCascade3Entity, Integer> {
}