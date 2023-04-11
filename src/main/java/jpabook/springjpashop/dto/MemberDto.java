package jpabook.springjpashop.dto;

import jpabook.springjpashop.Entity.MindMapEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto {
    private Long id;

    private String userId;

    private String userEmail;

    private String userPassword;
    private String userPasswordCheck;

    private List<MindMapEntity> mindMap = new ArrayList<>();

}
