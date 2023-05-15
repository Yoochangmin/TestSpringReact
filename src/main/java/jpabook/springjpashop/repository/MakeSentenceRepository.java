package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MakeSentenceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeSentenceRepository extends JpaRepository<MakeSentenceEntity, Long> {
}
