package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MakeSentence.PatentRelation;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import jpabook.springjpashop.dto.MakeSentence.PatentRelationDto;
import jpabook.springjpashop.dto.MindMap.MindMapNodeDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.PatentRelationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatentRelationService {
    @Autowired
    PatentRelationJpaRepository patentRelationJpaRepository;


    //연관단어 저장
    public ResponseDto<?> saveSentence(PatentRelationDto dto){

        PatentRelation patentRelation = new PatentRelation(dto);

        //데이터베이스에 patentSentence 저장
        try {
            patentRelationJpaRepository.save(patentRelation);
        }catch (Exception e){
            return ResponseDto.setFailed("Nodes Save Faild!");
        }
        return ResponseDto.setSuccess("Save Success!", dto);
    }

    //연관단어 리스트 불러오기
    private ResponseDto<?> getPatentList(){

        return null;
    }
}
