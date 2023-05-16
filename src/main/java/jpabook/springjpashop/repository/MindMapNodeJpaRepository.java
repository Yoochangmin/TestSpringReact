package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Min;
import java.util.List;

@Repository
public interface MindMapNodeJpaRepository extends JpaRepository<MindMapNode, Long> {
    List<MindMapNode> findByMindMapEntity_Id(Long Id);
//    boolean existsByMindMapId(Long mindmapId);

//    boolean existsById(Long Id);

    @Query("SELECT m.id FROM MindMap m ")
    List<MindMapNode> findAllNode(Long Id);

    List<MindMapNode> findAll();

}
