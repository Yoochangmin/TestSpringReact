package jpabook.springjpashop.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.dto.MemberStarDto;
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

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sentence_id")
    private MakeSentenceEntity makeSentenceEntity;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    public MemberStarEntity(MemberStarDto dto){
        this.memberEntity =dto.getMemberEntity();
        this.starRating = dto.getStarRating();
        this.makeSentenceEntity =dto.getMakeSentenceEntity();
    }
}
