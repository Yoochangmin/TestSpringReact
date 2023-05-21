package jpabook.springjpashop.api;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.dto.MakeSentence.MakeSentenceDto;
import jpabook.springjpashop.dto.MindMap.MindMapEdgeDto;
import jpabook.springjpashop.dto.MindMap.MindMapEntityDto;
import jpabook.springjpashop.dto.MindMap.MindMapNodeDto;
import jpabook.springjpashop.dto.MakeSentence.PatentSentenceDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.dto.WordRelationDto;
import jpabook.springjpashop.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MindMapApiController {
    @Autowired
    private final MindMapService mindMapService;
    @Autowired
    private final WordRelationService wordRelationService;
    @Autowired
    private final MemberService memberService;
    @Autowired
    private final MindMapNodeService mindMapNodeService;
    @Autowired
    private final MakeSentenceService makeSentenceService;
    @Autowired
    private final MindMapEdgeService mindMapEdgeService;

    @Autowired
    private final PatentSentenceService patentSentenceService;

    //마인드맵 저장 Api
    @PostMapping(value = "/api/auth/saveMindMap")
    public ResponseDto<?> createMindMap(@RequestBody MindMapEntityDto requestBody) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(requestBody);
        JsonNode rootNode = mapper.readTree(jsonString);

        ResponseDto<?> mindMap = mindMapService.createMindMap(requestBody);
        System.out.println("마인드맵정보 " + mindMap);

        // mindMapNode 파싱
        List<MindMapNodeDto> mindMapNodes = new ArrayList<>();
        JsonNode mindMapNodeArray = rootNode.path("mindMapNode");
        for (JsonNode node : mindMapNodeArray) {
            MindMapNodeDto dto = new MindMapNodeDto();
            dto.setId(node.path("id").asText());
            dto.setLabel(node.path("label").asText());
            dto.setType(node.path("type").asText());
            dto.setMindMapEntity((MindMapEntity) mindMap.getData());
            mindMapNodes.add(dto);
        }

        // minMapEdge 파싱
        List<MindMapEdgeDto> mindMapEdges = new ArrayList<>();
        JsonNode mindMapEdgeArray = rootNode.path("mindMapEdge");
        for (JsonNode edge : mindMapEdgeArray) {
            MindMapEdgeDto dto = new MindMapEdgeDto();

            dto.setId(edge.path("id").asText());
            dto.setSource(edge.path("source").asText());
            dto.setTarget(edge.path("target").asText());
            dto.setMindMapEntity((MindMapEntity) mindMap.getData());
            mindMapEdges.add(dto);
        }

        //노드 리스트 분리
        for (MindMapNodeDto mindNode : mindMapNodes)
        {
            mindMapNodeService.createNode(mindNode);
        }
        //엣지 리스트 분리
        for (MindMapEdgeDto mindEdge : mindMapEdges)
        {
            mindMapEdgeService.createEdge(mindEdge);
        }

        return mindMap;
    }

    //makeSentence 저장 patentSentence 저장
    @PostMapping("/api/auth/saveSentence")
    public ResponseDto<?> saveSentenceTest(@RequestBody MakeSentenceDto requestDto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("makeSentence데이터 확인"+requestDto);
        String jsonString = mapper.writeValueAsString(requestDto);
        JsonNode rootNode = mapper.readTree(jsonString);

        ResponseDto<?> makeSentence = makeSentenceService.saveSentence(requestDto);
        System.out.println("TEST 찾기"+ makeSentence.getData());

        // patentReation 파싱
        List<String> patentSentenceList = requestDto.getPatentSentence();
        for (String patentSentence : patentSentenceList){
            PatentSentenceDto dto = new PatentSentenceDto();
            dto.setPatentSentence(patentSentence);
            dto.setMakeSentenceEntity((MakeSentenceEntity) makeSentence.getData());
            patentSentenceService.saveSentence(dto);
        }

        return makeSentence;
    }


    //WordRelation 생성
    @PostMapping("/api/auth/saveWord")
    public ResponseDto<?> saveSentence(@RequestBody WordRelationDto requestBody){
            ResponseDto<?> result = wordRelationService.saveWord(requestBody);
            return result;
        }

    }
