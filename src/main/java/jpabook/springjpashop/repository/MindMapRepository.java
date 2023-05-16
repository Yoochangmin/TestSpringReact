package jpabook.springjpashop.repository;

import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MindMapRepository extends JpaRepository<MindMapEntity, Long> {
    List<MindMapEntity> findAll();
    @Query("SELECT m.id FROM MindMap m")
    List<Long> findAllIds();

    MindMapEntity findAllById(Long id);
}
