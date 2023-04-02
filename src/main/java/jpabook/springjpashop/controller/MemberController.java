package jpabook.springjpashop.controller;


import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.service.MemberService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("/api/test")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
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
