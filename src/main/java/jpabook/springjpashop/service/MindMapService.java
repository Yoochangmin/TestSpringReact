package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.dto.MindMap.MindMapEntityDto;
import jpabook.springjpashop.dto.MindMap.MindMapResponseDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.MindMapEdgeRepository;
import jpabook.springjpashop.repository.MindMapNodeJpaRepository;
import jpabook.springjpashop.repository.MindMapRepository;
import jpabook.springjpashop.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MindMapService{

    @Autowired
    private final MindMapRepository mindMapRepository;
    @Autowired
    private final MindMapNodeJpaRepository mindMapNodeJpaRepository;
    @Autowired
    private final MindMapEdgeRepository mindMapEdgeRepository;
    @Autowired
    private final MemberService memberService;
    @Autowired
    private final MemberJpaRepository memberJpaRepository;

    public ResponseDto<?> createMindMap(MindMapEntityDto dto) {
//        ResponseDto<?> signInpo = memberService.signIn(dto)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);

        MindMapEntity mindMapEntity = new MindMapEntity(dto);
        mindMapEntity.setMemberEntity((MemberEntity) authentication);

        //데이터베이스에 mindMap 저장
        try {
            mindMapRepository.save(mindMapEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Save Faild!");
        }
        return ResponseDto.setSuccess("Save Success!", mindMapEntity);
    }

    //마인드맵 전체 조회
//    public ResponseDto<MindMapResponseDto> getNodesAndEdgesByMindMapId() {
//        List<?> mindMapData = new ArrayList<>();
//        List<Long> mindMapId = mindMapRepository.findAllIds();
//        for (Long id  : mindMapId){
//        }
//
//        return ResponseDto.setSuccess("MindMapInforMation is sucess",null);
//    }



    }




