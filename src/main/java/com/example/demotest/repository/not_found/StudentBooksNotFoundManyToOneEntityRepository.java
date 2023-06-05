package com.example.demotest.repository.not_found;

import com.example.demotest.entity.not_found.StudentBooksNotFoundManyToOneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBooksNotFoundManyToOneEntityRepository extends JpaRepository<StudentBooksNotFoundManyToOneEntity, Integer> {
}