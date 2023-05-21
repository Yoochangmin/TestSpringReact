package jpabook.springjpashop.controller;

import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import jpabook.springjpashop.dto.MindMap.MindMapNodeDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.*;
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
    private final MindMapEdgeJpaRepository mindMapEdgeJpaRepository;
    @Autowired
    private final MindMapEdgeRepository mindMapEdgeRepository;

    //MindMapPk값 출력
    @GetMapping("/api/auth/mindMapAllList")
    public List<Long> getMindMapId() {
        return mindMapRepository.findAllIds();
    }

    @GetMapping("/api/auth/node")
    public ResponseEntity<?> getNodeData() {
        List<MindMapNode> list = mindMapNodeRepository.findByNodes(1L);
        System.out.println(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/api/auth/edge")
    public ResponseEntity<?> getEdgeData() {
        List<MindMapEdge> list = mindMapEdgeRepository.findByEdges(1L);
        System.out.println(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //마인드맵 전체 조회
    @GetMapping("/api/auth/mindMap")
    public ResponseDto<?> getAllMindMapData() {
        ResponseDto<?> result = mindMapService.getAllMindMapData();
        System.out.println(result);
        return result;
    }

    //마인드맵 개인 조회
    @GetMapping("/mindMap")
    public ResponseDto<?> getMyMindMapData() {
        ResponseDto<?> result = mindMapService.getMyMindMapData();
        System.out.println(result);
        return result;
    }



    //Sql SELET * FROM MindMap Where node_title LIKE %?%;
    //findByBoadTitleContains(String boardTitle);
    @GetMapping("api/auth/minMap/search/{mindMapNum}")
    public ResponseDto<?> getSearchList(@PathVariable Long id)
    {
        ResponseDto<?> result = mindMapService.getSearchMindMapData(id);
        return result;
    }


}
