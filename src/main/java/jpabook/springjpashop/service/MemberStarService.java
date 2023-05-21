package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MemberStarEntity;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.MemberStarJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberStarService {

    @Autowired
    private final MemberStarJpaRepository memberStarJpaRepository;

    public ResponseDto<?> saveStar() {

        MemberStarEntity memberStarEntity =new MemberStarEntity();
        memberStarEntity.setStarRating((byte) 0);
        //데이터베이스에 memberStar 저장
        try {
            memberStarJpaRepository.save(memberStarEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Star Save Faild!");
        }
        return ResponseDto.setSuccess("Save Success!", memberStarEntity);
    }


    }
