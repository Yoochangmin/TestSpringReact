package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.WordRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRelationRepository extends JpaRepository<WordRelationEntity, Long> {
}
