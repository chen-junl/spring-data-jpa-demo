package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.type3.StudentOneToManyType3Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToManyType3EntityRepository extends JpaRepository<StudentOneToManyType3Entity, Integer> {
}