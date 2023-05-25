package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.dto.MakeSentence.MakeSentenceDto;
import jpabook.springjpashop.dto.MakeSentence.MakeSentenceReponseDto;
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
import java.util.Date;
import java.util.Optional;

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
        MakeSentenceReponseDto makeSentenceReponseDto = new MakeSentenceReponseDto();
         String sentence= makeSentenceReponseDto.getSentence();
         String combineWord1 = makeSentenceReponseDto.getCombineWord1();
         String combineWord2 = makeSentenceReponseDto.getCombineWord2();
         byte show = makeSentenceReponseDto.getShow();
         Long mindMapEntityId =  makeSentenceReponseDto.getMindMapEntityId();

        return ResponseDto.setSuccess("Save Success!", makeSentenceReponseDto);
    }

}
