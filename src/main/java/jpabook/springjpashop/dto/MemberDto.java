package jpabook.springjpashop.dto;

import jpabook.springjpashop.Entity.MemberLikeEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto {
    private String userId;

    private String userEmail;

    private String userPassword;
    private String userPasswordCheck;

    private List<MindMapEntity> mindMap = new ArrayList<>();

//    private MemberLikeEntity memberLike;

}
