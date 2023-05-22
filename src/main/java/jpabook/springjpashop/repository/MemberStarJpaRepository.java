package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MemberStarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberStarJpaRepository extends JpaRepository<MemberStarEntity,Long> {

    @Query("SELECT m.id FROM MemberStar m WHERE m.makeSentenceEntity.id = :makeSentenceId")
    List<Long> MemberStarIdsByMakeSentenceId(@Param("makeSentenceId") Long makeSentenceId);
}
