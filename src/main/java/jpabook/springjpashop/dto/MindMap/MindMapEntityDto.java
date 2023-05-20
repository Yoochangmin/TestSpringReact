package jpabook.springjpashop.dto.MindMap;

import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MindMapEntityDto {

    private List<MindMapNode> mindMapNode;
    private List<MindMapEdge> mindMapEdge;

    private String highestWord;

    private MemberEntity memberEntity;

}
