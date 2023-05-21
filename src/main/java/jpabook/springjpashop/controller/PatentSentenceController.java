package jpabook.springjpashop.controller;


import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.service.PatentSentenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PatentSentenceController {

    @Autowired
    private final PatentSentenceService patentSentenceService;

    @GetMapping("/api/auth//patentSentence/{id}")
    public ResponseDto<?> getPatentList(@PathVariable Long id) {

        ResponseDto<?> result = this.patentSentenceService.getPatentList(id);
        return result;
    }
}