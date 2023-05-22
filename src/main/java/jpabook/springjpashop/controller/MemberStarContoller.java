package jpabook.springjpashop.controller;


import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.service.MemberStarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberStarContoller {
    @Autowired
    private final MemberStarService memberStarService;

    @GetMapping("api/auth/memberStar/total/{id}")
    public ResponseDto<?> getTotalStar(@PathVariable Long id) {

        ResponseDto<?> result = memberStarService.getTotalStar(id);

        return result;
    }
}
