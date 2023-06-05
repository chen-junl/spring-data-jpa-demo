package com.example.demotest.repository.not_found;

import com.example.demotest.entity.not_found.StudentNotFoundManyToOneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentNotFoundManyToOneEntityRepository extends JpaRepository<StudentNotFoundManyToOneEntity, Integer> {
}