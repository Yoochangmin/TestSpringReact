package jpabook.springjpashop.api;

import jpabook.springjpashop.domain.Member;
import jpabook.springjpashop.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;


@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;


    @PostMapping("/api/test/members")
    public CreateMemberResponse saveMember(@RequestBody @Valid CreateMemberRequest request){
        Member member = new Member();
        member.setName(request.getName());
        member.setPassword(request.getPassword());
//        member.setPassword(request.getPassword());
//        member.setEmail(request.getEmail());-

        Long id = memberService.join(member);
        return new CreateMemberResponse(id) ;
    }


    @Data
    static class CreateMemberRequest{
        private String name;
        private String userId;
        private String password;
//        private String email;
    }

    @Data
    static class CreateMemberResponse{
        private Long id;
//        @NotEmpty
//        private String userid;
//        @NotEmpty
//        private String password;
//
//        @NotEmpty
//        private String email;

        CreateMemberResponse(Long id/*,String userid,String password,String email*/){
            this.id= id;
//            this.userid=userid;
//            this.password = password;
//            this.email = email;
        }

    }
}
