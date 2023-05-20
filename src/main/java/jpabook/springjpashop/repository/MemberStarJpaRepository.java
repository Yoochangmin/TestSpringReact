package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MemberStarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberStarJpaRepository extends JpaRepository<MemberStarEntity,Long> {
}
