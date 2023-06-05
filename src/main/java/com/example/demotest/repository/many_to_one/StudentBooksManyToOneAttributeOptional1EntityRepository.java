package com.example.demotest.repository.many_to_one;

import com.example.demotest.entity.many_to_one.attribute.optional.StudentBooksManyToOneAttributeOptional1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBooksManyToOneAttributeOptional1EntityRepository extends JpaRepository<StudentBooksManyToOneAttributeOptional1Entity, Integer> {
}