package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MakeSentence.PatentRelation;
import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatentRelationJpaRepository extends JpaRepository<PatentRelation, Long> {
}
