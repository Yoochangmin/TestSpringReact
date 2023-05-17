package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MindMapEdgeJpaRepository extends JpaRepository<MindMapEdge, Long> {
//    List<MindMapEdge> findByMindMap(MindMapEntity mindMapEntity);;

//    boolean existsByMindMapId(Long mindmapId);
//        boolean existsById(Long Id);

        List<MindMapEdge> findAll();

}

