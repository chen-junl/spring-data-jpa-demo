package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.attribute.cascade.StudentOneToManyAttributeCascade2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToManyAttributeCascade2EntityRepository extends JpaRepository<StudentOneToManyAttributeCascade2Entity, Integer> {
}