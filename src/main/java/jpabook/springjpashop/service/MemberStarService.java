package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.Entity.MemberStarEntity;
import jpabook.springjpashop.dto.MemberStarDto;
import jpabook.springjpashop.dto.Patch.PatchMemberStarDto;
import jpabook.springjpashop.dto.Patch.PatchMemberStarResponseDto;
import jpabook.springjpashop.dto.PatchMemberResponseDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.MakeSentenceRepository;
import jpabook.springjpashop.repository.MemberJpaRepository;
import jpabook.springjpashop.repository.MemberStarJpaRepository;
import jpabook.springjpashop.repository.MemberStarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberStarService {

    @Autowired
    private final MemberStarJpaRepository memberStarJpaRepository;
    @Autowired
    private final MemberStarRepository memberStarRepository;

    @Autowired
    private final MemberJpaRepository memberJpaRepository;

    @Autowired
    private final MakeSentenceRepository makeSentenceRepository;


    //MemberStar 생성 및 DB 저장
    public ResponseDto<?> saveStar(MemberStarDto dto) {
        MemberEntity memberEntity =dto.getMemberEntity();
        MakeSentenceEntity makeSentenceEntity = dto.getMakeSentenceEntity();

        //makeSentence 객체가져오기
        System.out.println("dto 확인용:   " + memberEntity.getClass().getName());
        System.out.println("dto 확인용:   " + makeSentenceEntity);

        MemberStarEntity memberStarEntity = new MemberStarEntity(dto);
        //데이터베이스에 memberStar 저장
        try {
            memberStarJpaRepository.save(memberStarEntity);
        } catch (Exception e) {
            return ResponseDto.setFailed("Star Save Faild!");
        }
        return ResponseDto.setSuccess("Save Success!", memberStarEntity);
    }


    //MakeSentenceId에 해당하는 MemberStarTotal 출력
    public ResponseDto<?> getTotalStar(Long id) {

        Long totalRating = 0L;
        //인증된 회원의 마인드맵

        Optional<MakeSentenceEntity> makeSentenceEntityOptional = makeSentenceRepository.findById(id);
        if (makeSentenceEntityOptional.isPresent()) {
            System.out.println("옵셔널 데이터" + makeSentenceEntityOptional.get());
        } else {
            System.out.println("데이터 없음");
        }
        Long idx = makeSentenceEntityOptional.get().getId();

        List<MemberStarEntity> memberStarEntityList = memberStarRepository.findByMakeSentenceId(idx);
        for (MemberStarEntity starList : memberStarEntityList){
            Byte star = starList.getStarRating();
            System.out.println("점수: " + star);
            totalRating += star;
        }
        System.out.println("별점 총합" + totalRating);
        return ResponseDto.setSuccess("StarTotal 정보 조회 성공", totalRating);
    }

    //별점 수정 Api
    public ResponseDto<PatchMemberStarResponseDto> patchMemberStar(PatchMemberStarDto dto, Long makeSentenceId , String userId){
        Byte starRating = dto.getStarRating();
        //별점을 주는 makeSentence 객체
        MakeSentenceEntity makeSentenceEntity;
        MemberEntity memberEntity;
        try {
            memberEntity = memberJpaRepository.findByUserId(userId);
            System.out.println(memberEntity);
                if (memberEntity ==null)
                    return ResponseDto.setFailed("인증된 회원이 조회되지 않습니다");

            makeSentenceEntity =makeSentenceRepository.findById(makeSentenceId).orElse(null);
            System.out.println(makeSentenceEntity);
                if (makeSentenceEntity == null)
                    return ResponseDto.setFailed("해당 결합문장이 존재하지 않습니다.");


        }catch (Exception e){
            return ResponseDto.setFailed("DataBase Error");
        }

        MemberStarEntity memberStarEntity = memberStarJpaRepository.findByMemberIdAndMakeSenteceId(makeSentenceEntity.getId(),memberEntity.getId());
        System.out.println("조건에 맞는 memberStar 출력" + memberStarEntity);

        memberStarEntity.setStarRating(starRating);
        memberStarJpaRepository.save(memberStarEntity);

        PatchMemberStarResponseDto patchMemberStarResponseDto = new PatchMemberStarResponseDto();
        patchMemberStarResponseDto.setStarRating(starRating);
        patchMemberStarResponseDto.setUserId(userId);

        return ResponseDto.setSuccess("Success", patchMemberStarResponseDto);
    }
}
