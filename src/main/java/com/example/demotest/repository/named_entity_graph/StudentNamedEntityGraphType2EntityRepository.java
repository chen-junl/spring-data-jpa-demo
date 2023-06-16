package com.example.demotest.repository.named_entity_graph;

import com.example.demotest.entity.named_entity_graph.StudentNamedEntityGraphType2Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentNamedEntityGraphType2EntityRepository extends JpaRepository<StudentNamedEntityGraphType2Entity, Integer> {


    @Override
    @EntityGraph(attributePaths = {"books"})
    List<StudentNamedEntityGraphType2Entity> findAll();
}