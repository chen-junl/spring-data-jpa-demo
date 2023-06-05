package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.attribute.cascade.StudentOneToManyAttributeCascade1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToManyAttributeCascade1EntityRepository extends JpaRepository<StudentOneToManyAttributeCascade1Entity, Integer> {
}