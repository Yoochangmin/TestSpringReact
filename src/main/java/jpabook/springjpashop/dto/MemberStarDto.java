package jpabook.springjpashop.dto;

import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberStarDto {

    private byte starRating;
    private MakeSentenceEntity makeSentenceEntity;

    private MemberEntity memberEntity;


}
