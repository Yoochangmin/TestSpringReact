package jpabook.springjpashop.controller;

import jpabook.springjpashop.dto.MindMap.MindMapEntityDto;
import jpabook.springjpashop.dto.MindMap.MindMapRequestDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.service.MindMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class testController {
    private MindMapService mindMapService;


    // Spring - DTO 이용
    public class JsonDTO {
        private String name;
        private String age;
        // setter, getter, toString 메서드
    }
    public class JsonArrayDTO {
        private List<JsonDTO> items;
        // setter, getter, toString 메서드
    }

    //마인드맵 전체 조회
    @GetMapping("/api/auth/mindMapTest")
    public ResponseDto<?> getAllMindMapData() {
        ResponseDto<?> result =mindMapService.getAllTestData();
        System.out.println(result);
        return result;
    }
}