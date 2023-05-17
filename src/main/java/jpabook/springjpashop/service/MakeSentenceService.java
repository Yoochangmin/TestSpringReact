package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.dto.MakeSentence.MakeSentenceDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.MakeSentenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MakeSentenceService {
    @Autowired
    private final MakeSentenceRepository makeSentenceRepository;

    private final MakeSentenceEntity makeSentenceEntity;

    public ResponseDto<?> saveSentence(MakeSentenceDto dto) {
        String Word1 = dto.getCombineWord1();

        MakeSentenceEntity makeSentenceEntity = new MakeSentenceEntity(dto);

        //데이터 베이스에 sentence 저장
        try {
            makeSentenceRepository.save(makeSentenceEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Save Faild!");
        }

        return ResponseDto.setSuccess("Save Success!", makeSentenceEntity);
    }

}
