package jpabook.springjpashop.dto.MindMap;


import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import lombok.*;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data @Getter @Setter
public class MindMapEdgeDto {
    private String id;
    private String source;
    private String target;

    private MindMapEntity mindMapEntity;


    @Override
    public String toString() {
        return "MindMapEdge [id=" + id + ", source=" + source + ", target=" +target + "]";
    }
}
