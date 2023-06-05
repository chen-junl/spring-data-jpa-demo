package com.example.demotest.repository.many_to_many;

import com.example.demotest.entity.many_to_many.attribute.fetch.CourseManyToManyAttributeFetch2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseManyToManyAttributeFetch2EntityRepository extends JpaRepository<CourseManyToManyAttributeFetch2Entity, Integer> {
}