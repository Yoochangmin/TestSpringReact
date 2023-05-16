package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.dto.MemberDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.dto.SignInDto;
import jpabook.springjpashop.dto.SignInResponseDto;
import jpabook.springjpashop.repository.MemberJpaRepository;
import jpabook.springjpashop.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    private final TokenProvider tokenProvider;
    @Autowired
    private final MemberJpaRepository memberJpaRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //회원가입
    public ResponseDto<?> signUp(MemberDto dto){
        String userId = dto.getUserId();
        String userPassword = dto.getUserPassword();
        String userPasswordCheck = dto.getUserPasswordCheck();
        String userEmail = dto.getUserEmail();

//         id 중복 확인
        try {
            if(memberJpaRepository.existsByUserId(userId))
                return ResponseDto.setFailed("Existed Email!!");
        }catch (Exception e){
            return ResponseDto.setFailed("Data Base Erroe!!");
        }
        System.out.println("id확인" + userId);
        System.out.println("비밀번호 확인" + userPassword);
        //비밀번호가 다르면 failed response 변환
        if (!userPassword.equals(userPasswordCheck))
            return ResponseDto.setFailed("password does not matched");

        //MemberEntity 생성
        MemberEntity memberEntity = new MemberEntity(dto);

        //비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(userPassword);
        memberEntity.setUserPassword(encodedPassword);

        //데이터베이스에 Entity 저장
        try {
            memberJpaRepository.save(memberEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Sign Up Faild!");
        }

        return ResponseDto.setSuccess("Sign Up Success!", dto);

    }

    //로그인 서비스
    public ResponseDto<SignInResponseDto> signIn(SignInDto dto) {

        String userId = dto.getUserId();  // 유저 아이디 값
        String userPassword = dto.getUserPassword(); // 유저 비밀번호 값

        System.out.println("유저정보 검색" + dto);
        MemberEntity memberEntity = null;
        try {
            memberEntity = memberJpaRepository.findByUserId(userId);
            System.out.println(memberEntity);
            //아이디가 틀릴 경우
            if (memberEntity == null) return ResponseDto.setFailed("Sign In Failed : Id is not consist");
            //비밀번호가 틀릴 경우
            System.out.println("비밀번호" + userPassword + "다른" + memberEntity.getUserPassword());
            if (!passwordEncoder.matches(userPassword, memberEntity.getUserPassword()))
                return ResponseDto.setFailed("Sign In Failed  : PW is not consist");
        } catch (Exception error) {
            return ResponseDto.setFailed("Database Error");
        }

        memberEntity.setUserPassword("");

        String token = tokenProvider.create(userId);
        int exprTime = 3600000;

        SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, memberEntity);
        return ResponseDto.setSuccess("Sign In success", signInResponseDto);
    }



//    //회원 전체 조회
//    public List<MemberEntity> findMembers() {
//        return memberRepository.findAll();
//    }
//    public MemberEntity findOne(Long memberId) {
//        return memberRepository.findOne(memberId);
//    }

}
