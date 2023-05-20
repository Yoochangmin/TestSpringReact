package jpabook.springjpashop.controller;


import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.service.PatentRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PatentController {

//    @Autowired
//    private final PatentRelationService patentRelationService
//    //마인드맵 개인 조회
//    @GetMapping("/patentList")
//    public ResponseDto<?> getPatentList() {
//        ResponseDto<?> result = patentRelationService.getPatentList();
//        System.out.println(result);
//        return result;
//    }
}
