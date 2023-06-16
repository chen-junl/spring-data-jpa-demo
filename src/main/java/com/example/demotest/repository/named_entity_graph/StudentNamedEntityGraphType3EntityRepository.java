package com.example.demotest.repository.named_entity_graph;

import com.example.demotest.entity.named_entity_graph.StudentNamedEntityGraphType3Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentNamedEntityGraphType3EntityRepository extends JpaRepository<StudentNamedEntityGraphType3Entity, Integer> {
    @Override
    @EntityGraph(value = "Student3.books")
    List<StudentNamedEntityGraphType3Entity> findAll();
}