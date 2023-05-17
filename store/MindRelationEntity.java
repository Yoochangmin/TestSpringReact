package jpabook.springjpashop.Entity;


import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.dto.MindRelationDto;
import lombok.*;

import javax.persistence.*;

@Entity(name = "mind_relation")
@Table(name = "mind_relation")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MindRelationEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mind_relation_id")
    private Long id;

    @Column(name = "root_word")
    private String rootWord;

    private String word;

    @OneToOne(mappedBy = "mindRelation", fetch = FetchType.LAZY)
    private MindMapEntity mindMap;


    public MindRelationEntity(MindRelationDto dto) {
        this.id = dto.getId();
        this.rootWord = dto.getRootWord();
        this.word = dto.getWord();
        this.mindMap = dto.getMindMap();
    }
}
