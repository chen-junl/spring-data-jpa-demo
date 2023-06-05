package com.example.demotest.repository.one_to_one;

import com.example.demotest.entity.one_to_one.attribute.cascade.StudentDetailOneToOneAttributeCascade1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailOneToOneAttributeCascade1EntityRepository extends JpaRepository<StudentDetailOneToOneAttributeCascade1Entity, Integer> {
}