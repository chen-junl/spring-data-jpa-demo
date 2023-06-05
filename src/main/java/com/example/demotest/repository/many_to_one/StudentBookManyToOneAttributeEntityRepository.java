package com.example.demotest.repository.many_to_one;

import com.example.demotest.entity.many_to_one.attribute.StudentBookManyToOneAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBookManyToOneAttributeEntityRepository extends JpaRepository<StudentBookManyToOneAttributeEntity, Integer> {
}