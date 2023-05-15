package jpabook.springjpashop.Entity;


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
public class PatentRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="patent_relation_id")
    private Long id;

    @Column(name = "patent_sentence")
    private String patentSentence;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "make_sentence_id")
    private MakeSentenceEntity makeSentenceEntity;
}
