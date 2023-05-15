package jpabook.springjpashop.Entity;

import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.dto.MemberLikeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "MemberLike")
@Table(name = "MemberLike")
public class MemberLikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="member_like_id")
    private Long id;
    private byte like;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mind_map_id")
    private MindMapEntity mindMapEntity;


    public MemberLikeEntity(MemberLikeDto dto) {
        this.like =dto.getLike();
        this.mindMapEntity= getMindMapEntity();
    }



}
