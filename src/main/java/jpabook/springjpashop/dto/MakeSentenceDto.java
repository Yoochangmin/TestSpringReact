package jpabook.springjpashop.dto;


import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MakeSentenceDto {

    private String sentence;
    private String combineWord1;
    private String combineWord2;

    Date publicationDate;

    private byte starRating;

    private byte show;




    private MindMapEntity mindMapEntity;


}
