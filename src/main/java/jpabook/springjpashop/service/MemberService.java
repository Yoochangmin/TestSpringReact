package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.dto.MemberDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.MemberRepository;
import jpabook.springjpashop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional(readOnly = true)
@Transactional

@RequiredArgsConstructor
public class MemberService {

//    @Autowired
//    private final MemberRepository memberRepository;

    @Autowired
    private final UserRepository userRepository;

    public ResponseDto<?> signUp(MemberDto dto){
        String userEmail = dto.getUserEmail();
        String userId = dto.getUserId();
        String userPassword = dto.getUserPassword();
        String userPasswordCheck = dto.getUserPasswordCheck();

        // id 중복 확인
//        try {
//            if(userRepository.existsById(userEmail))
//                return ResponseDto.setFailed("Existed Email!!");
//        }catch (Exception e){
//            return ResponseDto.setFailed("Data Base Erroe!!");
//        }

        //비밀번호가 다르면 failed response 변환
        if (!userPassword.equals(userPasswordCheck))
            return ResponseDto.setFailed("password does not matched");

        MemberEntity memberEntity = new MemberEntity(dto);
        //데이터베이스에 Entity 저장
        try {
            userRepository.save(memberEntity);
        }catch (Exception e){
            return ResponseDto.setSuccess("Sign Up Success!",null);
        }

        return ResponseDto.setSuccess("Sign Up Success!", null);
    }



//    /**
//     * 회원 가입
//     */
//    @Transactional
//    public Long join(MemberEntity member) {
//        validateDuplicateMember(member); //중복 회원 검증
//        userRepository.save(member);
//        System.out.println("가입된 멤버 정보 출력" + member);
//        return member.getId();
//    }
//
//    private void validateDuplicateMember(MemberEntity member) {
//        List<MemberEntity> findMembers = memberRepository.findByName(member.getUserId());
//        if (!findMembers.isEmpty()) {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }
//    }
//
//    //회원 전체 조회
//    public List<MemberEntity> findMembers() {
//        return memberRepository.findAll();
//    }
//
//    public MemberEntity findOne(Long memberId) {
//        return memberRepository.findOne(memberId);
//    }

}
