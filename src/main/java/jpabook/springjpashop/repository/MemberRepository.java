package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;


    public void save(MemberEntity member) {
        em.persist(member);
    }

    public MemberEntity findOne(Long id) {
        return em.find(MemberEntity.class, id);
    }

    public List<MemberEntity> findAll() {
        return em.createQuery("select m from MemberEntity m", MemberEntity.class)
                .getResultList();
    }

    public Optional<MemberEntity> findByName(String name) {
        List<MemberEntity> result = em.createQuery("select m from MemberEntity m where m.name = :name", MemberEntity.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    public Optional<MemberEntity> findById(String userId){
        List<MemberEntity> result = em.createQuery("select m from  MemberEntity m where m.userId = :userId", MemberEntity.class)
                .setParameter("userId", userId)
                .getResultList();
        return result.stream().findAny();
    }

     public Optional<MemberEntity> existById(String userEmail){
         List<MemberEntity> result = em.createQuery("select m from  MemberEntity m where m.userEmail = :userEmail", MemberEntity.class)
                 .setParameter("userEmail", userEmail)
                 .getResultList();
         return result.stream().findAny();
     }

}
