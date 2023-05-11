package jpabook.springjpashop.dto;

import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MindRelationDto {

    private Long id;
    private String rootWord;
    private String word;
    private MindMapEntity mindMap;

}
