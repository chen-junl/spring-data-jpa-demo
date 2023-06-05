package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.type1.StudentBooksOneToManyType1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBooksOneToManyType1EntityRepository extends JpaRepository<StudentBooksOneToManyType1Entity, Integer> {
}