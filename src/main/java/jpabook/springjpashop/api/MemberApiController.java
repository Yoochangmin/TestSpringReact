package jpabook.springjpashop.api;

import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import jpabook.springjpashop.dto.MemberDto;
import jpabook.springjpashop.dto.MindMap.MindMapEdgeDto;
import jpabook.springjpashop.dto.MindMap.MindMapEntityDto;
import jpabook.springjpashop.dto.MindMap.MindMapNodeDto;
import jpabook.springjpashop.dto.MindMap.MindMapRequestDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.dto.SignInDto;
import jpabook.springjpashop.dto.SignInResponseDto;
import jpabook.springjpashop.service.MemberService;
import jpabook.springjpashop.service.MindMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;
    private final MindMapService mindMapService;

    //회원가입
    @PostMapping("/api/auth/signUp")
    public ResponseDto<?> signUp(@RequestBody @Valid MemberDto requestBody){
        ResponseDto<?> result = memberService.signUp(requestBody);
        System.out.println(requestBody);
        System.out.println(requestBody.getClass().getName());
        return result;
    }

    //로그인
    @PostMapping("/api/auth/signIn")
    public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody){
        ResponseDto<SignInResponseDto> result = memberService.signIn(requestBody);
        System.out.println(result);
        return result;
    }

    //


}
