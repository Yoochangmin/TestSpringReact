package jpabook.springjpashop.Entity.MakeSentence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.dto.MakeSentence.MakeSentenceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @Column(name ="make_sentence_id")
    private Long id;

    private String sentence;

    private String combineWord1;
    private String combineWord2;


    private byte show;

    private LocalDateTime nowDataTime;

//    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mind_map_id")
    private MindMapEntity mindMapEntity;

//    @OneToMany(mappedBy = "makeSentenceEntity", fetch = FetchType.LAZY)
//    private List<PatentSentenceEntity> patentSentenceEntity;


    // 연관관계 메서드
    public MakeSentenceEntity(MakeSentenceDto dto){
        this.sentence = dto.getSentence();
        this.combineWord1 = dto.getCombineWord1();
        this.combineWord2 = dto.getCombineWord2();
        this.show = dto.getShow();
    }



}
