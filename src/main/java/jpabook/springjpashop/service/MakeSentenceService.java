package jpabook.springjpashop.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.dto.MakeSentence.MakeSentenceDto;
import jpabook.springjpashop.dto.MakeSentence.MakeSentenceReponseDto;
import jpabook.springjpashop.dto.MindMap.MindMapNodeDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.MakeSentenceRepository;
import jpabook.springjpashop.repository.MemberJpaRepository;
import jpabook.springjpashop.repository.MindMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MakeSentenceService {
    @Autowired
    private final MakeSentenceRepository makeSentenceRepository;

    @Autowired
    private final MemberJpaRepository memberJpaRepository;
    @Autowired
    private final MindMapRepository mindMapRepository;
    private final MakeSentenceEntity makeSentenceEntity;

    public ResponseDto<?> saveSentence(MakeSentenceDto dto) {
        //인증된 회원의 마인드맵
        Long mindMapId = dto.getMindMapEntityId();
        System.out.println(mindMapId);
        MindMapEntity mindMapEntity = mindMapRepository.findById(mindMapId).orElse(null);
        try {
            mindMapRepository.findById(mindMapId).orElse(null);
        }catch (Exception e){
            return ResponseDto.setFailed("마인드맵 아이디 찾기 실패");
        }

        //가입 날짜 시간
        System.out.println("마인드맵 Id" + mindMapId);
        System.out.println();

        MakeSentenceEntity makeSentenceEntity = new MakeSentenceEntity(dto);
        makeSentenceEntity.setNowDataTime(LocalDateTime.now());
        makeSentenceEntity.setMindMapEntity(mindMapEntity);
        //데이터 베이스에 sentence 저장
        try {
            makeSentenceRepository.save(makeSentenceEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Save Faild!");
        }
        System.out.println(makeSentenceEntity);
        MakeSentenceReponseDto makeSentenceReponseDto = new MakeSentenceReponseDto();
        makeSentenceReponseDto.setMakeSentenceId(makeSentenceEntity.getId());
         makeSentenceReponseDto.setSentence(makeSentenceEntity.getSentence());
         makeSentenceReponseDto.setCombineWord1(makeSentenceEntity.getCombineWord1());
         makeSentenceReponseDto.setCombineWord2(makeSentenceEntity.getCombineWord2());
         makeSentenceReponseDto.setShow(makeSentenceEntity.getShow());
         makeSentenceReponseDto.setMindMapEntityId(makeSentenceEntity.getMindMapEntity().getId());
        return ResponseDto.setSuccess("Save Success!", makeSentenceReponseDto);
    }


    public  List<MakeSentenceReponseDto> searchSentence(String Sentence) {

        List<MakeSentenceEntity> SentenceList = makeSentenceRepository.findBySentenceLike("%" + Sentence + "%");

        Map<Long,Map<String,String>> ListData = new HashMap<>();

        System.out.println(SentenceList);
        List<MakeSentenceReponseDto> makeSentenceReponseDto = new ArrayList<>();
        for (MakeSentenceEntity makeSentence : SentenceList) {

            System.out.println("makeSenteceData" + makeSentence);

            MakeSentenceReponseDto dto = new MakeSentenceReponseDto();
            dto.setMakeSentenceId(makeSentence.getId());
            dto.setSentence(makeSentence.getSentence());
            dto.setCombineWord1(makeSentence.getCombineWord1());
            dto.setCombineWord2(makeSentence.getCombineWord2());
            dto.setShow(makeSentence.getShow());
            dto.setMindMapEntityId(makeSentence.getMindMapEntity().getId());
            makeSentenceReponseDto.add(dto);
        }



//        System.out.println("최종 확인" + ResponseMakeSentenceData);
        return  makeSentenceReponseDto;
    }


}
