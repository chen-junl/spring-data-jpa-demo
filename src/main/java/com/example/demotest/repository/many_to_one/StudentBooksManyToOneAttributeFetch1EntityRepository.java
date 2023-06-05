package com.example.demotest.repository.many_to_one;

import com.example.demotest.entity.many_to_one.attribute.fetch.StudentBooksManyToOneAttributeFetch1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBooksManyToOneAttributeFetch1EntityRepository extends JpaRepository<StudentBooksManyToOneAttributeFetch1Entity, Integer> {
}