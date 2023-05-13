package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
//import jpabook.springjpashop.MindMapMapper;
import jpabook.springjpashop.dto.MindMap.MindMapEdgeDto;
import jpabook.springjpashop.dto.MindMap.MindMapEntityDto;
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
    private final MindMapEdgeService edgeService;

    public ResponseDto<?> createMindMap(MindMapEntityDto dto) {
        String highestWord= dto.getHighestWord();
//        List<MindMapNodeDto> mindMapNoes = dto.getMindMapNode();
//        List<MindMapEdgeDto> mindMapEdges = dto.getMindMapEdge();

//        MindMapNode mindMapNode = new MindMapNode();
//        MindMapEdge mindMapEdge = new MindMapEdge();

        MindMapEntity mindMapEntity = new MindMapEntity(dto);
        // 노드 엣지 DB 저장
//        nodeService.createNode((MindMapNodeDto) mindMapNodes);
//        edgeService.createEdge((MindMapEdgeDto) mindMapEdges);

        //데이터베이스에 mindMap 저장
        try {
            mindMapRepository.save(mindMapEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Save Faild!");
        }
        return ResponseDto.setSuccess("Save Success!", mindMapEntity);
    }



        // 마인드맵 노드 저장
//        for (MindMapNodeDto nodes : mindMapNodes ){
//
//        }
        // 마인드맵 엣지 저장

        // 마인드맵 저장
//        return null;
    }

