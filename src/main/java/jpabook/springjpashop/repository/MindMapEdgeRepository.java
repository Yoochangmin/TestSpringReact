package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MindMapEdgeRepository {

    private final EntityManager em;

    public List<MindMapEdge> findByEdges(Long mindMapId) {
        String queryString = "SELECT n FROM MindMapEdge n WHERE n.mindMapEntity.id = :mindMapId";
        TypedQuery<MindMapEdge> query = em.createQuery(queryString, MindMapEdge.class);
        query.setParameter("mindMapId", mindMapId);
        return query.getResultList();
    }

    public List<MindMapEdge> findByEdge(Optional<MindMapEntity> mindMapId) {
        String queryString = "SELECT n FROM MindMapEdge n WHERE n.mindMapEntity.id = :mindMapId";
        TypedQuery<MindMapEdge> query = em.createQuery(queryString, MindMapEdge.class);
        query.setParameter("mindMapId", mindMapId);
        return query.getResultList();
    }
}
