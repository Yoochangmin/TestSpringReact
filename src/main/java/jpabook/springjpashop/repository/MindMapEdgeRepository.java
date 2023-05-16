package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MindMapEdgeRepository extends JpaRepository<MindMapEdge, Long> {
//    List<MindMapEdge> findByMindMap(MindMapEntity mindMapEntity);;

//    boolean existsByMindMapId(Long mindmapId);
//        boolean existsById(Long Id);

        List<MindMapEdge> findAll();

}

