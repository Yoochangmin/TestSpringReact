package jpabook.springjpashop.dto.MakeSentence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MakeSentenceReponseDto {
    private String sentence;
    private String combineWord1;
    private String combineWord2;

    private byte show;


    private Long mindMapEntityId;
}
