package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MakeSentenceRepository extends JpaRepository<MakeSentenceEntity, Long> {

//    Optional<MakeSentenceEntity> findById(Long makeSentenceId);

    List<MakeSentenceEntity> findBySentenceLike(String s);
    List<MakeSentenceEntity> findByCombineWord1OrCombineWord2(String word1, String Word2);

    List<MakeSentenceEntity>  findByMindMapEntityId(Long id);

}
