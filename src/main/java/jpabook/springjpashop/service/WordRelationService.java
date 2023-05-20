package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import jpabook.springjpashop.Entity.WordRelationEntity;
import jpabook.springjpashop.dto.MindMap.MindMapNodeDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.dto.WordRelationDto;
import jpabook.springjpashop.repository.WordRelationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WordRelationService {
    @Autowired
    private final WordRelationRepository wordRelationRepository;

    public ResponseDto<WordRelationDto> saveWord(WordRelationDto dto){

        WordRelationEntity wordRelationEntity = new WordRelationEntity(dto);
        //데이터베이스에 word 저장
        try {
            wordRelationRepository.save(wordRelationEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Word Save Faild!");
        }
        return ResponseDto.setSuccess("Save Success!", dto);
    }
}
