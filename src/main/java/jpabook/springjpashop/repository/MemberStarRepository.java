package jpabook.springjpashop.repository;


import jpabook.springjpashop.Entity.MakeSentence.PatentSentenceEntity;
import jpabook.springjpashop.Entity.MemberStarEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class MemberStarRepository {
    private final EntityManager em;

    public List<MemberStarEntity> findByMakeSentenceId(Long makeSentenceId) {
        String queryString = "select m from MemberStar m where m.makeSentenceEntity.id = :makeSentenceId";
        TypedQuery<MemberStarEntity> query = em.createQuery(queryString, MemberStarEntity.class);
        query.setParameter("makeSentenceId", makeSentenceId);
        return query.getResultList();
    }
}
