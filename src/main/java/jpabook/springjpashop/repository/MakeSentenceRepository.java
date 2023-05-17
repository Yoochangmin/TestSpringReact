package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeSentenceRepository extends JpaRepository<MakeSentenceEntity, Long> {
}
