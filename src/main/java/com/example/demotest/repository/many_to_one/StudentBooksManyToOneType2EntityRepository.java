package com.example.demotest.repository.many_to_one;

import com.example.demotest.entity.many_to_one.type2.StudentBooksManyToOneType2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBooksManyToOneType2EntityRepository extends JpaRepository<StudentBooksManyToOneType2Entity, Integer> {
}