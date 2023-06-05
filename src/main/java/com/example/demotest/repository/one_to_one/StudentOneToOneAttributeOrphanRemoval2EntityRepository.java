package com.example.demotest.repository.one_to_one;

import com.example.demotest.entity.one_to_one.attribute.orphanRemoval.StudentOneToOneAttributeOrphanRemoval2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOneToOneAttributeOrphanRemoval2EntityRepository extends JpaRepository<StudentOneToOneAttributeOrphanRemoval2Entity, Integer> {
}