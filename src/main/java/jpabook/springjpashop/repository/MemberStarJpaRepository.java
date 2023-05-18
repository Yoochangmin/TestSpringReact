package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MemberStar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberStarJpaRepository extends JpaRepository<MemberStar,Long> {
}
