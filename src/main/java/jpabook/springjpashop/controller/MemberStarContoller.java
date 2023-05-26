package jpabook.springjpashop.controller;


import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.Entity.MemberStarEntity;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.MemberJpaRepository;
import jpabook.springjpashop.repository.MemberStarJpaRepository;
import jpabook.springjpashop.service.MemberStarService;
import lombok.RequiredArgsConstructor;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MemberStarContoller {
    @Autowired
    private final MemberStarService memberStarService;
    @Autowired
    private final MemberJpaRepository memberJpaRepository;
    @Autowired
    private final MemberStarJpaRepository memberStarJpaRepository;
    @GetMapping("api/auth/memberStar/total/{id}")
    public ResponseDto<?> getTotalStar(@PathVariable Long id) {

        ResponseDto<?> result = memberStarService.getTotalStar(id);

        return result;
    }

    @GetMapping("api/auth/memberStar/{makeSentenceId}")
    public MemberStarEntity getMemberStar(@PathVariable Long makeSentenceId) {

        //인증된 회원정보
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        MemberEntity memberEntity = memberJpaRepository.findByUserId(userId);
        MemberEntity member =(MemberEntity) memberEntity;
        MemberStarEntity result = memberStarJpaRepository.findByMemberIdAndMakeSenteceId(member.getId(),makeSentenceId);
        return result;
    }


}
