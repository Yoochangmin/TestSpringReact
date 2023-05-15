package jpabook.springjpashop.dto.MindMap;

import jpabook.springjpashop.Entity.MakeSentenceEntity;
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

    private List<MindMapNode> mindMapNode;
    private List<MindMapEdge> mindMapEdge;

    private String highestWord;

    private MemberEntity memberEntity;
    private Long memberId;

    private MakeSentenceEntity makeSentenceEntity;

}
