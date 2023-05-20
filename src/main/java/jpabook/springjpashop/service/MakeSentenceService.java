package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.dto.MakeSentence.MakeSentenceDto;
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
        //인증된 회원정보
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        MemberEntity memberEntity = memberJpaRepository.findByUserId(userId);
        Long memberId = memberEntity.getId();
        //인증된 회원의 마인드맵

        System.out.println("마인드맵 엔티티정보"+ mindMapRepository.findById(memberId).orElse(null));


        //가입 날짜 시간

        MakeSentenceEntity makeSentenceEntity = new MakeSentenceEntity(dto);
        makeSentenceEntity.setMindMapEntity(mindMapRepository.findById(memberId).orElse(null));
//        makeSentenceEntity.setPublicationDate(Date);

        //데이터 베이스에 sentence 저장
        try {
            makeSentenceRepository.save(makeSentenceEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Save Faild!");
        }

        return ResponseDto.setSuccess("Save Success!", makeSentenceEntity);
    }

}
