package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.type2.StudentOneToManyType2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToManyType2EntityRepository extends JpaRepository<StudentOneToManyType2Entity, Integer> {
}