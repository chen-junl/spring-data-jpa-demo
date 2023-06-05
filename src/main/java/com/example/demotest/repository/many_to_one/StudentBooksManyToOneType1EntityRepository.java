package com.example.demotest.repository.many_to_one;

import com.example.demotest.entity.many_to_one.type1.StudentBooksManyToOneType1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBooksManyToOneType1EntityRepository extends JpaRepository<StudentBooksManyToOneType1Entity, Integer> {
}