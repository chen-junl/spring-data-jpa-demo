package com.example.demotest.repository.many_to_one;

import com.example.demotest.entity.many_to_one.type2.StudentManyToOneType2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentManyToOneType2EntityRepository extends JpaRepository<StudentManyToOneType2Entity, Integer> {
}