package jpabook.springjpashop.controller;


import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MakeSentence.PatentRelation;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.service.PatentRelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PatentController {

    @Autowired
    private final PatentRelationService patentRelationService;

    @GetMapping("/api/auth//patentSentence/{id}")
    public ResponseDto<?> getPatentList(@PathVariable Long id) {

        ResponseDto<?> result = this.patentRelationService.getPatentList(id);
        return result;
    }
}