package jpabook.springjpashop.Entity;

import jpabook.springjpashop.dto.MemberDto;
import jpabook.springjpashop.dto.MindeMapDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "MindMap")
@Table(name = "MindMap")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MindMapEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mind_map_id")
    private long id;
    @Column(name = "hight_word")
    private String hightWord;

    public MindMapEntity(MindeMapDto dto){
        this.hightWord = dto.getHightWord();
    }

//    @Column(name = "lowest_word_group")
//    private List<TrizEntity> lowestWord = new ArrayList<TrizEntity>();

//    @Column(name = "mindMap_image")
//    private ?? image;
//    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
//    private MakeTrizEntity makeTriz;

//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name = "mind_map_id")
//    private MindRelation mindRelation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;




//    //연관관계 메소드
//    public void setMindRelation(MindRelation mindRelation){
//        this.mindRelation =mindRelation;
//        mindRelation.setMindMap(this);
//    }
}
