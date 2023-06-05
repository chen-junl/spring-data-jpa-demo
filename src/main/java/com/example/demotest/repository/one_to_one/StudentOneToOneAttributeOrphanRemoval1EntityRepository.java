package com.example.demotest.repository.one_to_one;

import com.example.demotest.entity.one_to_one.attribute.orphanRemoval.StudentOneToOneAttributeOrphanRemoval1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToOneAttributeOrphanRemoval1EntityRepository extends JpaRepository<StudentOneToOneAttributeOrphanRemoval1Entity, Integer> {
}