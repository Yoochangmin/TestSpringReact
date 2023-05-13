package jpabook.springjpashop.Entity.MindMap;

import jpabook.springjpashop.dto.MindMap.MindMapNodeDto;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "MindMapNode")
@Table(name = "MindMapNode")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class MindMapNode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="mind_map_node_id")
    private Long sequence;

    private String id;
    private String label;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mind_map_id")
    private MindMapEntity mindMapEntity;

    //연관관계 매서드
//     public void setMindMapEntity(MindMapEntity mindMapEntity) {
//            this.mindMapEntity = mindMapEntity;
//            mindMapEntity.getMindMapNodes().add(this);
//     }
        public MindMapNode(MindMapNodeDto dto){
        this.id = dto.getId();
        this.label = dto.getLabel();
        this.type = dto.getType();
        this.mindMapEntity=dto.getMindMapEntity();
    }

}