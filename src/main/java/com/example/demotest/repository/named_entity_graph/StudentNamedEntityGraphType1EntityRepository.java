package com.example.demotest.repository.named_entity_graph;

import com.example.demotest.entity.named_entity_graph.StudentNamedEntityGraphType1Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentNamedEntityGraphType1EntityRepository extends JpaRepository<StudentNamedEntityGraphType1Entity, Integer> {


    @Override
    @EntityGraph(value = "Student.books")
    List<StudentNamedEntityGraphType1Entity> findAll();
}