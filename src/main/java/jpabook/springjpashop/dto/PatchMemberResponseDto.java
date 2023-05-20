package jpabook.springjpashop.dto;

import jpabook.springjpashop.Entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchMemberResponseDto {
    private MemberEntity member;
}
