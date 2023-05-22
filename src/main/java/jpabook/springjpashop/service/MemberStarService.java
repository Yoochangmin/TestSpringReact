package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.Entity.MemberStarEntity;
import jpabook.springjpashop.dto.MemberStarDto;
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
        //인증된 회원의 마인드맵

        Optional<MakeSentenceEntity> makeSentenceEntityOptional = makeSentenceRepository.findById(id);
        if (makeSentenceEntityOptional.isPresent()) {
            System.out.println("옵셔널 데이터" + makeSentenceEntityOptional.get());
        } else {
            System.out.println("데이터 없음");
        }
        Long idx = makeSentenceEntityOptional.get().getId();

        List<MemberStarEntity> memberStarEntityList = memberStarRepository.findByMakeSentenceId(idx);

        System.out.println(memberStarEntityList);

        for (MemberStarEntity starList : memberStarEntityList){
            Byte star = starList.getStarRating();
            System.out.println("별점 준문장" + starList.getMakeSentenceEntity().getId());
            System.out.println("별점 준 멤버" + starList.getMemberEntity().getUserId());
        }

//        return ResponseDto.setSuccess("StarTotal 정보 조회 성공", memberStarEntityList);
        return null;
    }
}
