package com.example.demotest.repository.many_to_many;

import com.example.demotest.entity.many_to_many.attribute.fetch.CourseManyToManyAttributeFetch1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseManyToManyAttributeFetch1EntityRepository extends JpaRepository<CourseManyToManyAttributeFetch1Entity, Integer> {
}