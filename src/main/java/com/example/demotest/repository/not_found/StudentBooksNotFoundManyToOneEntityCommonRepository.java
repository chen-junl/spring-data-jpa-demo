package com.example.demotest.repository.not_found;

import com.example.demotest.entity.not_found.StudentBooksNotFoundManyToOneCommonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBooksNotFoundManyToOneEntityCommonRepository extends JpaRepository<StudentBooksNotFoundManyToOneCommonEntity, Integer> {
}