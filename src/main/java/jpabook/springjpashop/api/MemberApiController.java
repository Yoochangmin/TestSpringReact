package jpabook.springjpashop.api;

import jpabook.springjpashop.dto.MemberDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.dto.SignInDto;
import jpabook.springjpashop.dto.SignInResponseDto;
import jpabook.springjpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;

    //회원가입
    @PostMapping("/how-about-idea")
    public ResponseDto<?> signUp(@RequestBody @Valid MemberDto requestBody){
        System.out.println(requestBody);
        ResponseDto<?> result = memberService.signUp(requestBody);
        return result;
    }

    //로그인
    @PostMapping("/api/auth/signIn")
    public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody){
        ResponseDto<SignInResponseDto> result = memberService.signIn(requestBody);
        return result;
    }

}
