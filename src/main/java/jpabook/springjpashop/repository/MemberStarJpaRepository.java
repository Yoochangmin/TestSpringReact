package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MemberEntity;
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


    @Query("SELECT m from MemberStar m where m.memberEntity.id = :memberId and m.makeSentenceEntity.id = :makeSentenceId")
    MemberStarEntity findByMemberIdAndMakeSenteceId(Long memberId, Long makeSentenceId);
}
