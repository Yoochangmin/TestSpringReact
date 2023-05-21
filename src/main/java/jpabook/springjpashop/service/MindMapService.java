package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import jpabook.springjpashop.dto.MindMap.MindMapEntityDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.ibatis.ognl.Ognl.getValue;


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
        MemberEntity memberEntity = null;
        Long id ;
        // 로그인한 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        memberEntity = memberJpaRepository.findByUserId(userId);
        System.out.println("인증된멤버정보:" + memberEntity);

        id = memberEntity.getId();

        if (memberEntity == null) {
            return ResponseDto.setFailed("Member not found");
        }

        MindMapEntity mindMapEntity = new MindMapEntity(dto);
        mindMapEntity.setMemberEntity(memberEntity);

//         데이터베이스에 mindMap 저장
        try {
            mindMapRepository.save(mindMapEntity);
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
        for (List<?> mindMapDatum : mindMapData) {
            System.out.println("MindMapData 조회" + mindMapDatum);
        }

        return ResponseDto.setSuccess("MindMapInforMation is sucess", mindMapData);
    }

    //마인드맵 개인 조회
    public ResponseDto<?> getMyMindMapData() {
        List<List<?>> mindMapData = new ArrayList<>();
        //인증된 회원정보
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        MemberEntity memberEntity = memberJpaRepository.findByUserId(userId);
        Long memberId = memberEntity.getId();
        //인증된 회원의 마인드맵
        System.out.println("마인드맵 엔티티정보"+ mindMapRepository.findById(1L).orElse(null));

        List<Long> mindMapId = mindMapRepository.findMindMapIdsByMemberId(memberId);

        System.out.println("마인드맵 id" + mindMapId);
            for (Long id : mindMapId) {
                List<MindMapNode> nodeData = mindMapNodeRepository.findByNodes(id);
                List<MindMapEdge> edgeData = mindMapEdgeRepository.findByEdges(id);

                mindMapData.add(nodeData);
                mindMapData.add(edgeData);

            }
        return ResponseDto.setSuccess("마인드맵 정보 조회 성공", mindMapData);
    }

    //마인드맵 검색 조회
    public ResponseDto<?> getSearchMindMapData(Long id) {
        List<List<?>> mindMapData = new ArrayList<>();

        Optional<MindMapEntity> mindMapEntityId = this.mindMapRepository.findById(id);

        if (mindMapEntityId.isPresent()) {
            System.out.println( mindMapEntityId.get());
        } else {
            System.out.println( "데이터 없음");
        }
        Long idx = mindMapEntityId.get().getId();
        List<MindMapNode> nodeData = mindMapNodeRepository.findByNode(idx);
        List<MindMapEdge> edgeData = mindMapEdgeRepository.findByEdge(idx);

            mindMapData.add(nodeData);
            mindMapData.add(edgeData);

        return ResponseDto.setSuccess("마인드맵 정보 조회 성공",  mindMapData);
    }

    }




