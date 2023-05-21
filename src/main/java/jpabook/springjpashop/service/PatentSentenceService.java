package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MakeSentence.PatentSentenceEntity;
import jpabook.springjpashop.dto.MakeSentence.PatentSentenceDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.patentSentenceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatentSentenceService {

    @Autowired
    private final patentSentenceJpaRepository patentSentenceJpaRepository;


    //연관단어 저장
    public ResponseDto<?> saveSentence(PatentSentenceDto dto){

        PatentSentenceEntity patentSentenceEntity = new PatentSentenceEntity(dto);

        //데이터베이스에 patentSentence 저장
        try {
            patentSentenceJpaRepository.save(patentSentenceEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Nodes Save Faild!");
        }
        return ResponseDto.setSuccess("Save Success!", dto);
    }
    //연관단어 리스트 불러오기
    public ResponseDto<?> getPatentList(Long id){

        List<PatentSentenceEntity> patentSentenceEntityList = patentSentenceJpaRepository.findByMakeSentenceEntityId(id);

        return ResponseDto.setSuccess("Success message", patentSentenceEntityList);
    }
}
