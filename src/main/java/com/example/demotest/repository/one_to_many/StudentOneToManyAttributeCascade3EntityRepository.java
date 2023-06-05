package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.attribute.cascade.StudentOneToManyAttributeCascade3Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToManyAttributeCascade3EntityRepository extends JpaRepository<StudentOneToManyAttributeCascade3Entity, Integer> {
}