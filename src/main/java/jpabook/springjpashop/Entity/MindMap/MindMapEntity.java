package jpabook.springjpashop.Entity.MindMap;

import jpabook.springjpashop.Entity.MemberEntity;
        import jpabook.springjpashop.dto.MindMap.MindMapEntityDto;
        import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name ="MindMap")
@Table(name = "MindMap")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class MindMapEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mind_map_id")
    private long id;
    private String highestWord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id" )
    private MemberEntity memberEntity;

    public MindMapEntity(MindMapEntityDto dto){
        this.highestWord = dto.getHighestWord();
    }

    //== 연관관계 매서드 ==//

    public void setMemberEntity(MemberEntity memberEntity){
        this.memberEntity=memberEntity;
        memberEntity.getMindMap().add(this);
    }
/**
 *  연관관계 메소드
    public void setMindRelation(MindRelation mindRelation){
        this.mindRelation =mindRelation;
        mindRelation.setMindMap(this);
    }
**/




}
