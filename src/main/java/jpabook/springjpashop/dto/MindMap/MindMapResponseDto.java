package jpabook.springjpashop.dto.MindMap;

import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MindMapResponseDto {

    private List<MindMapNode> mindMapNode;
    private List<MindMapEdge> mindMapEdge;
}
