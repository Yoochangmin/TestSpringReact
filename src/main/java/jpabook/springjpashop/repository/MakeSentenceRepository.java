package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakeSentenceRepository extends JpaRepository<MakeSentenceEntity, Long> {


    List<MakeSentenceEntity> findBySentenceLike(String s);
    List<MakeSentenceEntity> findByCombineWord1OrCombineWord2(String word1, String Word2);

}
