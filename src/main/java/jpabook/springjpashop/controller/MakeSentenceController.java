package jpabook.springjpashop.controller;
import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.repository.*;
import jpabook.springjpashop.service.MakeSentenceService;
import jpabook.springjpashop.service.PatentSentenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MakeSentenceController {

    @Autowired
    private final MakeSentenceService makeSentenceService;

    @Autowired
    private final MakeSentenceRepository makeSentenceRepository;

    private final PatentSentenceService patentSentenceService;
    @GetMapping("/api/auth/makeSentence/{id}")
    public MakeSentenceEntity getSentence(@PathVariable Long id) {

        Optional<MakeSentenceEntity> result = this.makeSentenceRepository.findById(id);


        if (result.isPresent()) {
            return result.get();
        } else {
            return result.orElse(null);
        }

    }

    @GetMapping("/api/auth/makeSentence/searchSentence/{Sentence}")
    public List<MakeSentenceEntity> searchSentence(@PathVariable String Sentence) {

        return  this.makeSentenceRepository.findBySentenceLike("%"+Sentence+"%");

    }

    @GetMapping("/api/auth/makeSentence/searchWord/{word}")
    public List<MakeSentenceEntity> searchWord(@PathVariable String word) {

        return  this.makeSentenceRepository.findByCombineWord1OrCombineWord2(word,word);

    }



}
