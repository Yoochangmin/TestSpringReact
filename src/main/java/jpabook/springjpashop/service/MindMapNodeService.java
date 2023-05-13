package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import jpabook.springjpashop.dto.MindMap.MindMapNodeDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.MindMapNodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MindMapNodeService {

    @Autowired
    private final MindMapNodeRepository mindMapNodeRepository;

    public ResponseDto<?> createNode(MindMapNodeDto dto){
        String id = dto.getId();
        String label = dto.getLabel();
        String type = dto.getType();
        MindMapEntity mindMapEntity =dto.getMindMapEntity();

        MindMapNode mindMapNode = new MindMapNode(dto);
//        System.out.println("여기임" + mindMapNode.getMindMapEntity().getId());
        //데이터베이스에 Node 저장
        try {
//            mindMapEntity.setId(1);
            mindMapNodeRepository.save(mindMapNode);
        }catch (Exception e){
            return ResponseDto.setFailed("Nodes Save Faild!");
        }
        return ResponseDto.setSuccess("Save Success!", dto);
    }
}
