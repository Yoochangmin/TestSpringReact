package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MindMapRepository extends JpaRepository<MindMapEntity, Long> {
    List<MindMapEntity> findAll();
    @Query("SELECT m.id FROM MindMap m")
    List<Long> findAllIds();

    @Query("SELECT m.id FROM MindMap m WHERE m.memberEntity.id = :memberId")
    List<Long> findMindMapIdsByMemberId(@Param("memberId") Long memberId);

    Optional<MindMapEntity> findById(Long memberId);

}
