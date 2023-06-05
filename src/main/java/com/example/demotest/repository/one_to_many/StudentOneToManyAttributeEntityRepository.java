package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.attribute.StudentOneToManyAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToManyAttributeEntityRepository extends JpaRepository<StudentOneToManyAttributeEntity, Integer> {
}