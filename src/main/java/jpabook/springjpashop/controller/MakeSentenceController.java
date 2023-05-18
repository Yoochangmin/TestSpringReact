package jpabook.springjpashop.controller;
import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import jpabook.springjpashop.dto.MakeSentence.MakeSentenceDto;
import jpabook.springjpashop.dto.MemberDto;
import jpabook.springjpashop.dto.MindMap.MindMapNodeDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.*;
import jpabook.springjpashop.service.MakeSentenceService;
import jpabook.springjpashop.service.MindMapNodeService;
import jpabook.springjpashop.service.MindMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MakeSentenceController {

    @Autowired
    private final MakeSentenceService makeSentenceService;

    @Autowired
    private final MakeSentenceRepository makeSentenceRepository;

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

    @PostMapping("/api/auth/makeSentence")
    public ResponseDto<?> makeSentence(@RequestBody @Valid MakeSentenceDto dto) {
        ResponseDto<?> result = makeSentenceService.saveSentence(dto);
        return result;
    }

}
