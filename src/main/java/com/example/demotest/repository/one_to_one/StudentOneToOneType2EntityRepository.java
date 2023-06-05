package com.example.demotest.repository.one_to_one;

import com.example.demotest.entity.one_to_one.type2.StudentOneToOneType2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToOneType2EntityRepository extends JpaRepository<StudentOneToOneType2Entity, Integer> {
}