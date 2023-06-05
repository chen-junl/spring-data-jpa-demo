package com.example.demotest.repository.many_to_many;

import com.example.demotest.entity.many_to_many.type2.StudentManyToManyType2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentManyToManyType2EntityRepository extends JpaRepository<StudentManyToManyType2Entity, Integer> {
}