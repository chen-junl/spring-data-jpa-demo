package com.example.demotest.repository.one_to_many;

import com.example.demotest.entity.one_to_many.attribute.orphanRemoval.StudentBookOneToManyAttributeOrphanRemoval2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentBookOneToManyAttributeOrphanRemoval2EntityRepository extends JpaRepository<StudentBookOneToManyAttributeOrphanRemoval2Entity, Integer> {
}