package jpabook.springjpashop.dto.MindMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class MindMapRequestDto {
    private List<MindMapNodeDto> mindMapNode;
    private List<MindMapEdgeDto> mindMapEdge;

}
