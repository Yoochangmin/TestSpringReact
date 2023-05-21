package jpabook.springjpashop.repository;


import jpabook.springjpashop.Entity.MakeSentence.PatentSentenceEntity;
import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PatentSentenceReopsitory {
    private final EntityManager em;

    public List<PatentSentenceEntity> findByMakeSentenceId(Long makeSentenceId) {
        String queryString = "select m from PatentSentence m where m.makeSentenceEntity.id = :makeSentenceId";
        TypedQuery<PatentSentenceEntity> query = em.createQuery(queryString, PatentSentenceEntity.class);
        query.setParameter("makeSentenceId", makeSentenceId);
        return query.getResultList();
    }

}
