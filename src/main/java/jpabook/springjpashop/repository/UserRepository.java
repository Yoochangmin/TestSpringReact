package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MemberEntity,String> {

}
