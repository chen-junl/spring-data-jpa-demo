package com.example.demotest.repository.many_to_one;

import com.example.demotest.entity.many_to_one.attribute.fetch.StudentBooksManyToOneAttributeFetch2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBooksManyToOneAttributeFetch2EntityRepository extends JpaRepository<StudentBooksManyToOneAttributeFetch2Entity, Integer> {
}