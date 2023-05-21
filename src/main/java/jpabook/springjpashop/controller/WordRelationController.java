package jpabook.springjpashop.controller;

import jpabook.springjpashop.Entity.WordRelationEntity;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.WordRelationRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.compiler.ast.Variable;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WordRelationController {

    @Autowired
    private final WordRelationRepository wordRelationRepository;

    @GetMapping("/api/auth/wordRelation/{word}")
    public List<WordRelationEntity> getWordRelation(@PathVariable String word){

        return this.wordRelationRepository.findByRootWord(word);

    }
    @GetMapping("/api/auth/wordRelation/{rootword}/{word}")
    public boolean CheckWordRelation(@PathVariable String rootword, @PathVariable String word)
    {
        List<WordRelationEntity> result = wordRelationRepository.findByRootWordAndWord(rootword, word);
        if(result.size()<=0)
            return false;
        else
            return true;
    }


}
