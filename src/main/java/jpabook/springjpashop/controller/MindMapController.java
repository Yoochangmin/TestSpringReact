package jpabook.springjpashop.controller;

import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import jpabook.springjpashop.repository.MindMapEdgeRepository;
import jpabook.springjpashop.repository.MindMapNodeRepository;
import jpabook.springjpashop.repository.MindMapNodeJpaRepository;
import jpabook.springjpashop.repository.MindMapRepository;
import jpabook.springjpashop.service.MindMapNodeService;
import jpabook.springjpashop.service.MindMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MindMapController {

    @Autowired
    private final MindMapService mindMapService;
    @Autowired
    private final MindMapRepository mindMapRepository;

    @Autowired
    private final MindMapNodeJpaRepository mindMapNodeJpaRepository;
    @Autowired
    private final MindMapNodeRepository mindMapNodeRepository;
    @Autowired
    private final MindMapNodeService mindMapNodeService;
    @Autowired
    private final MindMapEdgeRepository mindMapEdgeRepository;

    //마인드맵 전체 조회 api
//    @GetMapping("/api/auth/allMindMap")
//    public List<MindMapResponseDto> mindMapList(@PathVariable ) {
//        List<MindMapResponseDto> mindMap = mindMapRepository.findAll();
//        List<MindMapResponseDto> result = mindMap.stream()
//                .map(o -> new MindMapResponseDto())
//                .collect(toList());
//        return result;
//    }

    //마인드맵 조건 조회
//    @GetMapping("api/auth/mindMapList{minaMapId}")
//    public List<MindMapNode> getNodesByMindMapId(@PathVariable Long mindmapId) {
//        return (List<MindMapNode>) mindMapService.getNodesAndEdgesByMindMapId(mindmapId);
//    }

    //마인드맵 전체 조회
    @GetMapping("/api/auth/mindMapAllList")
    public List<Long> getMindMapList() {

        return mindMapRepository.findAllIds();
    }

    //마인드맵 노드 조회
    @GetMapping("/api/auth/nodes")
    public ResponseEntity<?> getNodes(@PathVariable Long Id) {
        List<MindMapNode> list = mindMapNodeJpaRepository.findByMindMapEntity_Id(1L);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping("/api/auth/node")
    public ResponseEntity<?> getNodeData() {
        List<MindMapNode> list = mindMapNodeRepository.findByMindMapId(1L);
        System.out.println(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
