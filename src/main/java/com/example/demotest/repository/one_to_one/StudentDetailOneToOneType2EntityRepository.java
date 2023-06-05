package com.example.demotest.repository.one_to_one;

import com.example.demotest.entity.one_to_one.type2.StudentDetailOneToOneType2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailOneToOneType2EntityRepository extends JpaRepository<StudentDetailOneToOneType2Entity, Integer> {
}