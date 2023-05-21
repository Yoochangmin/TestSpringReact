package jpabook.springjpashop.Entity;

import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "MemberStar")
@Table(name = "MemberStar")
public class MemberStarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="member_star_id", nullable = true)
    private Long id;

    private byte starRating;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sentence_id")
    private MakeSentenceEntity makeSentenceEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;
}
