package jpabook.springjpashop.repository;


import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MindMapNodeRepository {

    private final EntityManager em;

    public List<MindMapNode> findByNodes(Long mindMapId) {
        String queryString = "SELECT n FROM MindMapNode n WHERE n.mindMapEntity.id = :mindMapId";
        TypedQuery<MindMapNode> query = em.createQuery(queryString, MindMapNode.class);
        query.setParameter("mindMapId", mindMapId);
        System.out.println(query.getResultList());
        System.out.println(query.getResultList().getClass().getSimpleName());
        return query.getResultList();
    }
}
