package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import jpabook.springjpashop.dto.MindMap.MindMapEntityDto;
import jpabook.springjpashop.dto.MindMap.MindMapNodeDto;
import jpabook.springjpashop.dto.MindMap.MindMapResponseDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class MindMapService{

    @Autowired
    private final MindMapRepository mindMapRepository;
    @Autowired
    private final MindMapNodeRepository mindMapNodeRepository;
    @Autowired
    private final MindMapEdgeRepository mindMapEdgeRepository;
    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final MindMapNodeJpaRepository mindMapNodeJpaRepository;
    @Autowired
    private final MindMapEdgeJpaRepository mindMapEdgeJpaRepository;
    @Autowired
    private final MemberService memberService;
    @Autowired
    private final MemberJpaRepository memberJpaRepository;

    public ResponseDto<?> createMindMap(MindMapEntityDto dto) {
        // 로그인한 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
//        MemberEntity memberEntity = memberJpaRepository.findByUserId(userId);
//
//        if (memberEntity == null) {
//            return ResponseDto.setFailed("Member not found");
//        }

        MindMapEntity mindMapEntity = new MindMapEntity(dto);
//        mindMapEntity.setMemberEntity(memberEntity);

        // 데이터베이스에 mindMap 저장
        try {
            mindMapRepository.save(mindMapEntity);
        System.out.println("로그인한 사용자 정보 "+ userId);
        } catch (Exception e) {
            return ResponseDto.setFailed("Save Failed!");
        }

        return ResponseDto.setSuccess("Save Success!", mindMapEntity);
    }

    //마인드맵 전체 조회
    public ResponseDto<?> getAllMindMapData() {
        List<List<?>> mindMapData = new ArrayList<>();
        List<Long> mindMapId = mindMapRepository.findAllIds();
        for (Long id  : mindMapId){
            List<MindMapNode> nodeData = mindMapNodeRepository.findByNodes(id);
            List<MindMapEdge> edgeData = mindMapEdgeRepository.findByEdges(id);
            mindMapData.add(nodeData);
            mindMapData.add(edgeData);
        }

        return ResponseDto.setSuccess("MindMapInforMation is sucess", mindMapData);
    }
    public ResponseDto<?> getAllTestData() {
        Map<String, List<?>> mindMapData = new HashMap<>();

        List<Long> mindMapId = mindMapRepository.findAllIds();

        for (int i=0 ; i <mindMapId.size(); i++) {
            for (Long id : mindMapId) {
                List<MindMapNode> nodeData = mindMapNodeRepository.findByNodes(id);
                List<MindMapEdge> edgeData = mindMapEdgeRepository.findByEdges(id);

                mindMapData.put("mindMapNode", nodeData);
                mindMapData.put("mindMapEdge", edgeData);

            }
        }
        return ResponseDto.setSuccess("마인드맵 정보 조회 성공", mindMapData);
    }

    }




