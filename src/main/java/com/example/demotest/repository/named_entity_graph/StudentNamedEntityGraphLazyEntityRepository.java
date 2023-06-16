package com.example.demotest.repository.named_entity_graph;

import com.example.demotest.entity.named_entity_graph.StudentNamedEntityGraphLazyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentNamedEntityGraphLazyEntityRepository extends JpaRepository<StudentNamedEntityGraphLazyEntity, Integer> {
}