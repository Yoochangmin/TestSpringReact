package jpabook.springjpashop.dto.MakeSentence;


import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatentRelationDto {
    private String patentSentence;
    private MakeSentenceEntity makeSentenceEntity;

}
