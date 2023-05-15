package jpabook.springjpashop.controller;

import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.dto.MindMap.MindMapEntityDto;
import jpabook.springjpashop.repository.MindMapRepository;
import jpabook.springjpashop.service.MindMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class MindMapController {

    @Autowired
    private final MindMapService mindMapService;
    @Autowired
    private final MindMapRepository mindMapRepository;

    //마인드맵 전체 조회 api
    @GetMapping("/api/auth/allMindMap")
    public List<MindMapEntityDto> mindMapV3() {
        List<MindMapEntity> mindMap = mindMapRepository.findAll();
        List<MindMapEntityDto> result = mindMap.stream()
                .map(o -> new MindMapEntityDto())
                .collect(toList());
        return result;
    }


}
