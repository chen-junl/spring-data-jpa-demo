package com.example.demotest.repository.many_to_one;

import com.example.demotest.entity.many_to_one.attribute.optional.StudentBooksManyToOneAttributeOptional2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBooksManyToOneAttributeOptional2EntityRepository extends JpaRepository<StudentBooksManyToOneAttributeOptional2Entity, Integer> {
}