package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MindMapNodeRepository extends JpaRepository<MindMapNode, Long> {
}
