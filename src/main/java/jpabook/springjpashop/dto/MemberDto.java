package jpabook.springjpashop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto {
    private Long id;

    private String userId;

    private String userEmail;


    private String userPassword;
    private String userPasswordCheck;


}
