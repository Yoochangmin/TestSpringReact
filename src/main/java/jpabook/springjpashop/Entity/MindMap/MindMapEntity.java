package jpabook.springjpashop.Entity.MindMap;

//import jpabook.springjpashop.Entity.MindRelationEntity;
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

//    @OneToMany(mappedBy = "mindMapEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<MakeSentenceEntity> makeSentenceEntityList = new ArrayList<>();

//    @OneToOne(mappedBy = "mindMapEntity", fetch = FetchType.LAZY)
//    private MindRelationEntity mindRelationEntity;

//    @OneToOne(mappedBy = "mindMapEntity", fetch = FetchType.LAZY)
//    private MemberLikeEntity memberLikeEntity;

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
    //== 비즈니스 로직 ==//


//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "mind_map_id")
//    private MindRelationEntity mindRelationEntity;




}
