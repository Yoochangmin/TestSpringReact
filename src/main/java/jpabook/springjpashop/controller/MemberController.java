package jpabook.springjpashop.controller;


import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/uerInpo")
    public String getMember(@AuthenticationPrincipal MemberEntity memberEntity){
        System.out.println(memberEntity.getUserId());
        return "로그인된 사용자는"+ memberEntity.getUserId() + "입니다";
    }

    @GetMapping("/api/auth/user/{id}")
    public MemberEntity getUser(@PathVariable Long id){

        MemberEntity result = this.memberRepository.findOne(id);

        return result;

    }

//    @GetMapping("/members/new")
//    public String createForm(Model model) {
//        model.addAttribute("memberForm", new MemberEntity());
//        return "members/createMemberForm";
//    }

//    @PostMapping("/members/new")
//    public String create(@Valid MemberEntity form, BindingResult result) {
//        if (result.hasErrors()) {
//            return "members/createMemberForm";
//        }
//
//        MemberEntity member = new MemberEntity();
//        member.setUserId(form.getUserId());
//        member.setEmail(form.getEmail());
//        member.setPassword(form.getPassword());
//        memberService.join(member);
//        return "redirect:/";
//
//    }

//    @GetMapping("/members")
//    public String list(Model model) {
//        List<MemberEntity> members = memberService.findMembers();
//        model.addAttribute("members", members);
//        return "members/memberList";
//    }


}
