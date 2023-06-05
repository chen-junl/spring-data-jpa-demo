package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.attribute.fetch.StudentOneToManyAttributeFetch2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToManyAttributeFetch2EntityRepository extends JpaRepository<StudentOneToManyAttributeFetch2Entity, Integer> {
}