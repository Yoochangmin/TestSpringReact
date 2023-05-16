package jpabook.springjpashop.api;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.dto.MakeSentenceDto;
import jpabook.springjpashop.dto.MindMap.MindMapEdgeDto;
import jpabook.springjpashop.dto.MindMap.MindMapEntityDto;
import jpabook.springjpashop.dto.MindMap.MindMapNodeDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.service.MakeSentenceService;
import jpabook.springjpashop.service.MindMapEdgeService;
import jpabook.springjpashop.service.MindMapNodeService;
import jpabook.springjpashop.service.MindMapService;
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
    private final MindMapNodeService mindMapNodeService;
    @Autowired
    private final MakeSentenceService makeSentenceService;
    @Autowired
    private final MindMapEdgeService mindMapEdgeService;
    @PostMapping("/api/auth/saveMindMap")
    public ResponseDto<?> createMindMap(@RequestBody MindMapEntityDto requestBody) throws JsonProcessingException {
        //Object jsonString = requestBody; // JSON 데이터
        System.out.println(requestBody);
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(requestBody);
        JsonNode rootNode = mapper.readTree(jsonString);

        ResponseDto<?> mindMap = mindMapService.createMindMap(requestBody);


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
        System.out.println("마인드맵 노드 분리: " + mindMapNodes);

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

        System.out.println("마인드맵 엣지 분리: " + mindMapEdges);

        //노드 리스트 분리
        for (MindMapNodeDto mindNode : mindMapNodes)
        {
            mindMapNodeService.createNode(mindNode);
            System.out.println(mindNode);
        }
        //엣지 리스트 분리
        for (MindMapEdgeDto mindEdge : mindMapEdges)
        {
            mindMapEdgeService.createEdge(mindEdge);
            System.out.println(mindEdge);
        }

        return mindMap;
    }

    @PostMapping("/api/auth/saveSentence")
    public ResponseDto<?> saveSentence(@RequestBody MakeSentenceDto requestBody) throws JsonProcessingException {
        ResponseDto<?> result = makeSentenceService.saveSentence(requestBody);
        System.out.println(requestBody);
        System.out.println(requestBody.getClass().getName());
        return result;
    }
}
