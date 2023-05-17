package jpabook.springjpashop.Entity.MakeSentence;


import jpabook.springjpashop.dto.MakeSentence.MakeSentenceDto;
import jpabook.springjpashop.dto.MakeSentence.PatentRelationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "PatentRelation")
@Table(name = "PatentRelation")
public class PatentRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="patent_relation_id")
    private Long id;

    @Column(name = "patent_sentence")
    private String patentSentence;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "make_sentence_id")
    private MakeSentenceEntity makeSentenceEntity;

    public PatentRelation(PatentRelationDto dto){
        this.patentSentence = dto.getPatentSentence();
        this.makeSentenceEntity =dto.getMakeSentenceEntity();
    }
}
