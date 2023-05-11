package jpabook.springjpashop.Entity.MindMap;

import jpabook.springjpashop.Entity.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MemberEntity;
//import jpabook.springjpashop.Entity.MindRelationEntity;
import jpabook.springjpashop.Entity.MemberLikeEntity;
import jpabook.springjpashop.Entity.MindRelationEntity;
import jpabook.springjpashop.dto.MindMap.MindMapEntityDto;
import jpabook.springjpashop.dto.MindMap.MindMapRequestDto;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "MindMap")
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
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    @OneToMany(mappedBy = "mindMapEntity",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MindMapNode> mindMapNodes = new ArrayList<>();

    @OneToMany(mappedBy = "mindMapEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MindMapEdge> mindMapEdges = new ArrayList<>();

    @OneToMany(mappedBy = "mindMapEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MakeSentenceEntity> makeSentenceEntityList = new ArrayList<>();

    @OneToOne(mappedBy = "mindMapEntity", fetch = FetchType.LAZY)
    private MindRelationEntity mindRelationEntity;

    @OneToOne(mappedBy = "mindMapEntity", fetch = FetchType.LAZY)
    private MemberLikeEntity memberLikeEntity;



    //== 연관관계 매서드 ==//
    public void addMindMapNode(MindMapNode mindMapNode){
        mindMapNodes.add(mindMapNode);
        mindMapNode.setMindMapEntity(this);
    }
    public void addMindMapEdge(MindMapEdge mindMapEdge){
        mindMapEdges.add(mindMapEdge);
        mindMapEdge.setMindMapEntity(this);
    }

    public void addMakeSentence(MakeSentenceEntity makeSentence){
        makeSentenceEntityList.add(makeSentence);
        makeSentence.setMindMapEntity(this);
    }

    public void setMemberEntity(MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }

    public MindMapEntity(MindMapEntityDto dto){
        this.memberEntity = dto.getMemberEntity();
        this.highestWord = dto.getHightWord();
        this.mindMapNodes = dto.getMindMapNodes();
        this.mindMapEdges = dto.getMindMapEdges();
        this.mindRelationEntity = dto.getMindRelationEntity();
        this.memberLikeEntity = dto.getMemberLikeEntity();
    }

    //== 생성 메서드 ==//
//    public static MindMapEntity createMindMap(MindMapNode mindMapNodes, MindMapEdge mindMapEdges){
//        MindMapEntity mindMap = new MindMapEntity();
//        for (MindMapNode mindMapNode : mindMapNodes) {
//            mindMap.setMindMapEdges();
//        }
//        mindMap.setMindMapNodes();
//    }


    //== 비즈니스 로직 ==//

    // --json 파일 노드 엣지 분리 --//
    public String JsonSeparate(MindMapRequestDto dto){
        return null;
    };

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "mind_map_id")
//    private MindRelationEntity mindRelationEntity;



//    //연관관계 메소드
//    public void setMindRelation(MindRelation mindRelation){
//        this.mindRelation =mindRelation;
//        mindRelation.setMindMap(this);
//    }
}
