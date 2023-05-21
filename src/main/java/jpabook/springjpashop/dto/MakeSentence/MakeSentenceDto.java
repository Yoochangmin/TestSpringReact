package jpabook.springjpashop.dto.MakeSentence;


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

    private byte show;

    private List<String> patentSentence;

//    private MindMapEntity mindMapEntity;


}
