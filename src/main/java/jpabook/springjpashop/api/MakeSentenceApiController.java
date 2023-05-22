package jpabook.springjpashop.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.dto.MakeSentence.MakeSentenceDto;
import jpabook.springjpashop.dto.MakeSentence.PatentSentenceDto;
import jpabook.springjpashop.dto.MemberStarDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.service.MakeSentenceService;
import jpabook.springjpashop.service.MemberStarService;
import jpabook.springjpashop.service.PatentSentenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MakeSentenceApiController {
    @Autowired
    private final MakeSentenceService makeSentenceService;

    @Autowired
    private final PatentSentenceService patentSentenceService;

    @Autowired
    private final MemberStarService memberStarService;


    //makeSentence 저장 patentSentence 저장 memberStar저장
    @PostMapping("/api/auth/saveSentence")
    public ResponseDto<?> saveSentenceTest(@RequestBody MakeSentenceDto requestDto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("makeSentence데이터 확인"+requestDto);
        String jsonString = mapper.writeValueAsString(requestDto);
        JsonNode rootNode = mapper.readTree(jsonString);


        //makeSentence 저장
        ResponseDto<?> makeSentence = makeSentenceService.saveSentence(requestDto);
        System.out.println("TEST 찾기"+ makeSentence.getData());

        //makeSentence 객체 데이터
        MakeSentenceEntity makeSentenceData = (MakeSentenceEntity) makeSentence.getData();


        // patentSentence 파싱 및 PatentSentence 저장
        List<String> patentSentenceList = requestDto.getPatentSentence();
        for (String patentSentence : patentSentenceList){
            PatentSentenceDto dto = new PatentSentenceDto();
            dto.setPatentSentence(patentSentence);
            dto.setMakeSentenceEntity(makeSentenceData);
            patentSentenceService.saveSentence(dto);
        }

        return makeSentence;
    }
}
