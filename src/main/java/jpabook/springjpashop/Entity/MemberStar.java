package jpabook.springjpashop.Entity;

import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data @Entity
public class MemberStar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="member_star_id")
    private Long id;

    private byte starRating;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mind_map_id")
    private MindMapEntity mindMapEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;
}
