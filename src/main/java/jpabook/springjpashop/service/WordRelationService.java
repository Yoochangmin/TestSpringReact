package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.WordRelationEntity;
import jpabook.springjpashop.dto.Patch.PatchWordRelationResponseDto;
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

    public ResponseDto<WordRelationEntity> saveWord(WordRelationDto dto){

        WordRelationEntity wordRelationEntity = new WordRelationEntity(dto);
        //데이터베이스에 word 저장
        try {
            wordRelationRepository.save(wordRelationEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Word Save Faild!");
        }
        return ResponseDto.setSuccess("Save Success!", wordRelationEntity);
    }

    public ResponseDto<PatchWordRelationResponseDto> increaseWeight(Long wordId){
        System.out.println("워드 아이디 :" + wordId);
        Long weight;
        //wordRelation 생성

        WordRelationEntity wordRelationEntity = wordRelationRepository.findById(wordId).orElse(null);
        System.out.println("워드릴레이션 객체" + wordRelationEntity);
        weight = wordRelationEntity.getWeight() + 1L;
        wordRelationEntity.setWeight(weight);

        try {
            wordRelationRepository.save(wordRelationEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("DataBase Error");
        }
        PatchWordRelationResponseDto patchWordRelationResponseDto = new PatchWordRelationResponseDto();
        patchWordRelationResponseDto.setWordId(wordId);
        patchWordRelationResponseDto.setWeight(weight);

        return ResponseDto.setSuccess("Success", patchWordRelationResponseDto);
    }
}
