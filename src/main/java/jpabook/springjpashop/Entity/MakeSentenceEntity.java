package jpabook.springjpashop.Entity;

import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.dto.MakeSentenceDto;
import jpabook.springjpashop.dto.MindMap.MindMapNodeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "MakeSentence")
@Table(name = "MakeSentence")
@Component

public class MakeSentenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="sentence_id")
    private Long id;

    private String sentence;

    private String combineWord1;
    private String combineWord2;

    private byte starRating;

    private byte show;

    @Temporal(TemporalType.DATE)
    Date publicationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mind_map_id")
    private MindMapEntity mindMapEntity;

    @OneToOne(mappedBy = "makeSentenceEntity")
    private PatentRelationEntity patentRelationEntity;


    public MakeSentenceEntity(MakeSentenceDto dto){
        this.sentence = dto.getSentence();
        this.combineWord1 = dto.getCombineWord1();
        this.combineWord2 = dto.getCombineWord2();
        this.publicationDate = dto.getPublicationDate();
        this.show = dto.getShow();
        this.mindMapEntity = dto.getMindMapEntity();
    }
}
