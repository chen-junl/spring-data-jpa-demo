package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.type3.StudentBooksOneToManyType3Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBooksOneToManyType3EntityRepository extends JpaRepository<StudentBooksOneToManyType3Entity, Integer> {
}