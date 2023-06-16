package com.example.demotest.repository.named_entity_graph;

import com.example.demotest.entity.named_entity_graph.StudentBooksNamedEntityGraphEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBooksNamedEntityGraphEntityRepository extends JpaRepository<StudentBooksNamedEntityGraphEntity, Integer> {
}