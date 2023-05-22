package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MakeSentence.PatentSentenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatentSentenceJpaRepository extends JpaRepository<PatentSentenceEntity, Long> {


}
