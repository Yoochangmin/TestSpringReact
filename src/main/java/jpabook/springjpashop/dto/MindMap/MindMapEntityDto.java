package jpabook.springjpashop.dto.MindMap;

import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.Entity.MemberLikeEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import jpabook.springjpashop.Entity.MindRelationEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MindMapEntityDto {

    private List<MindMapNode> mindMapNodes;
    private List<MindMapEdge> mindMapEdges;
    private MemberEntity memberEntity;

    private MindRelationEntity mindRelationEntity;
    private MemberLikeEntity memberLikeEntity;
    private String hightWord;
//    private String lowestWord;

}
