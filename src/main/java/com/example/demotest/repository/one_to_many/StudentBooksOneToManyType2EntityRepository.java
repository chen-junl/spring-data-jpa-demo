package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.type2.StudentBooksOneToManyType2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBooksOneToManyType2EntityRepository extends JpaRepository<StudentBooksOneToManyType2Entity, Integer> {
}