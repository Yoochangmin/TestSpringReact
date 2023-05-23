package jpabook.springjpashop.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MakeSentence.PatentSentenceEntity;
import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.dto.MakeSentence.MakeSentenceDto;
import jpabook.springjpashop.dto.MemberStarDto;
import jpabook.springjpashop.dto.Patch.PatchMemberStarDto;
import jpabook.springjpashop.dto.Patch.PatchMemberStarResponseDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.MakeSentenceRepository;
import jpabook.springjpashop.repository.MemberJpaRepository;
import jpabook.springjpashop.service.MakeSentenceService;
import jpabook.springjpashop.service.MemberStarService;
import jpabook.springjpashop.service.PatentSentenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequiredArgsConstructor
public class MemberStarApiController {
    @Autowired
    private final MakeSentenceService makeSentenceService;
    @Autowired
    private final MemberStarService memberStarService;

    @Autowired
    private final MakeSentenceRepository makeSentenceRepository;
    @Autowired
    private final MemberJpaRepository memberJpaRepository;

    //MemberStar 저장
    @PostMapping("/api/auth/saveMemberStar/{makeSentenceId}")
    public ResponseDto<?> saveMemberStar(@RequestBody MemberStarDto requestBody, @PathVariable Long makeSentenceId){

        //별점을 주는 makeSentence 객체
        MakeSentenceEntity makeSentenceEntity = makeSentenceRepository.findById(makeSentenceId).orElse(null);

        //인증된 회원정보
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        System.out.println("인증 회원 정보 찾기" + userId);
        MemberEntity memberEntity = memberJpaRepository.findByUserId(userId);
        MemberEntity member =(MemberEntity) memberEntity;


        //memberStarDto에 값 추가
        MemberStarDto dto = new MemberStarDto();
        dto.setMakeSentenceEntity(makeSentenceEntity);
        dto.setMemberEntity(member);
        dto.setStarRating(requestBody.getStarRating());

        ResponseDto<?> result = memberStarService.saveStar(dto);

        return result;
    }

    @PatchMapping("/api/auth/patchMemberStar/{makeSentenceId}")
    public ResponseDto<PatchMemberStarResponseDto> patchMemberStar(@RequestBody PatchMemberStarDto requestBody, @PathVariable Long makeSentenceId, @AuthenticationPrincipal String userId){

        PatchMemberStarDto dto = new PatchMemberStarDto(requestBody.getStarRating());

        ResponseDto<PatchMemberStarResponseDto> result = memberStarService.patchMemberStar(dto,makeSentenceId,userId);
        return result;
    }

}
