package com.example.demotest.repository.many_to_many;

import com.example.demotest.entity.many_to_many.attribute.StudentManyToManyAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentManyToManyAttributeEntityRepository extends JpaRepository<StudentManyToManyAttributeEntity, Integer> {
}