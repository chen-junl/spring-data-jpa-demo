package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.attribute.StudentBookOneToManyAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBookOneToManyAttributeEntityRepository extends JpaRepository<StudentBookOneToManyAttributeEntity, Integer> {
}