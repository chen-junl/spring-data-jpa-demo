package com.example.demotest.repository.named_entity_graph;

import com.example.demotest.entity.named_entity_graph.StudentNamedEntityGraphEagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentNamedEntityGraphEagerEntityRepository extends JpaRepository<StudentNamedEntityGraphEagerEntity, Integer> {

}