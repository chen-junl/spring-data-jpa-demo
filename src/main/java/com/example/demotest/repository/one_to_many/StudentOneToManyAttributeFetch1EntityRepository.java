package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.attribute.fetch.StudentOneToManyAttributeFetch1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToManyAttributeFetch1EntityRepository extends JpaRepository<StudentOneToManyAttributeFetch1Entity, Integer> {
}