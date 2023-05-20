package jpabook.springjpashop.dto.MakeSentence;


import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.Entity.MakeSentence.PatentRelation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MakeSentenceDto {

    private String sentence;
    private String combineWord1;
    private String combineWord2;

    private Date publicationDate;

    private byte totalStarRating;
    private byte memberStarRating;

    private byte show;

    private List<String> patentRelation;

    private MindMapEntity mindMapEntity;


}
