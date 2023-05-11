package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
//import jpabook.springjpashop.MindMapMapper;
import jpabook.springjpashop.dto.MindMap.MindMapEdgeDto;
import jpabook.springjpashop.dto.MindMap.MindMapNodeDto;
import jpabook.springjpashop.dto.MindMap.MindMapRequestDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.MindMapEdgeRepository;
import jpabook.springjpashop.repository.MindMapNodeRepository;
import jpabook.springjpashop.repository.MindMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MindMapService{

    @Autowired
    private final MindMapRepository mindMapRepository;
    private final MindMapEntity mindMapEntity;
    private final MindMapNodeRepository mindMapNodeRepository;
    private final MindMapEdgeRepository mindMapEdgeRepository;
    private final MindMapNodeService nodeService;
//
    private final MindMapEdgeService edgeService;

    public ResponseDto<?> createMindMap(MindMapRequestDto dto) {
        List<MindMapNodeDto> mindMapNodes = dto.getMindMapNode();
        List<MindMapEdgeDto> mindMapEdges = dto.getMindMapEdge();


        //json 데이터 노드와 엣지 분리
        String result = mindMapEntity.JsonSeparate(dto);

//        MindMapNode mindMapNode = new MindMapNode();
//        MindMapEdge mindMapEdge = new MindMapEdge();

        MindMapEntity mindMapEntity = new MindMapEntity();
        // 노드 엣지 DB 저장
        nodeService.createNode((MindMapNodeDto) mindMapNodes);
        edgeService.createEdge((MindMapEdgeDto) mindMapEdges);
//

        //데이터베이스에 mindMap 저장
        try {
            mindMapRepository.save(mindMapEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Save Faild!");
        }
        return ResponseDto.setSuccess("Save Success!", dto);
    }



        // 마인드맵 노드 저장
//        for (MindMapNodeDto nodes : mindMapNodes ){
//
//        }
        // 마인드맵 엣지 저장

        // 마인드맵 저장
//        return null;
    }

