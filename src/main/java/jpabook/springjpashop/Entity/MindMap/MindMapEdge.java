package jpabook.springjpashop.Entity.MindMap;

import jpabook.springjpashop.dto.MindMap.MindMapEdgeDto;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "MindMapEdge")
@Table(name = "MindMapEdge")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class MindMapEdge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="mind_map_edge_id")
    private Long sequence;

    private String id;
    private String source;
    private String target;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mind_map_id")
    private MindMapEntity mindMapEntity;

    //연관관계 매서드
    public void setMindMapEntity(MindMapEntity mindMapEntity) {

        this.mindMapEntity = mindMapEntity;
        mindMapEntity.getMindMapEdges().add(this);
    }
    public MindMapEdge(MindMapEdgeDto dto){
        this.id =dto.getId();
        this.source = dto.getSource();
        this.target = dto.getTarget();
    }

    // getters and setters
}