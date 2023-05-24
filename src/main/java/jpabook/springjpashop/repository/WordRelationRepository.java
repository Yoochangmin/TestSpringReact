package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.WordRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRelationRepository extends JpaRepository<WordRelationEntity, Long> {

    List<WordRelationEntity> findByRootWord(String word);
    List<WordRelationEntity> findByRootWordAndWord(String rootword , String word);

}
