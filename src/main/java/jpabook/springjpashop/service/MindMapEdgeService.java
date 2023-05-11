package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import jpabook.springjpashop.dto.MindMap.MindMapEdgeDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.MindMapEdgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MindMapEdgeService {
    @Autowired
    private final MindMapEdgeRepository mindMapEdgeRepository;


    public ResponseDto<?> createEdge(MindMapEdgeDto dto){
        String id = dto.getId();
        String source = dto.getSource();
        String target = dto.getTarget();

        MindMapEdge mindMapEdge = new MindMapEdge(dto);
        try {
            mindMapEdgeRepository.save(mindMapEdge);
        }catch (Exception e){
            return ResponseDto.setFailed("Edges Save Faild");
        }
        return ResponseDto.setSuccess("Save Success!", dto);
    }
}
