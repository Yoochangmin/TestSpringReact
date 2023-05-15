package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MemberEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.dto.MindMap.MindMapEntityDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.MindMapRepository;
import jpabook.springjpashop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MindMapService{

    @Autowired
    private final MindMapRepository mindMapRepository;
    @Autowired
    private final MemberService memberService;
    @Autowired
    private final UserRepository userRepository;

    public ResponseDto<?> createMindMap(MindMapEntityDto dto) {
//        ResponseDto<?> signInpo = memberService.signIn(dto)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

//        Long memberId = ((MemberEntity) authentication.getPrincipal()).getMemberEntity().getId();
//        dto.setMemberId(memberId);


        MindMapEntity mindMapEntity = new MindMapEntity(dto);

        //데이터베이스에 mindMap 저장
        try {
            mindMapRepository.save(mindMapEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Save Faild!");
        }
        return ResponseDto.setSuccess("Save Success!", mindMapEntity);
    }

    }




