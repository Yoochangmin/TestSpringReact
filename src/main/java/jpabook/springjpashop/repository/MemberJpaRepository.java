package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberJpaRepository extends JpaRepository<MemberEntity,Long> {
     boolean existsByUserIdAndUserPassword(String userId, String userPassword);
     boolean existsByUserId(String userId);

     MemberEntity findByUserId(String userId);

     Optional<MemberEntity> findById(Long memberId);

}
