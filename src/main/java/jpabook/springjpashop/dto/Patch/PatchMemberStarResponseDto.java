package jpabook.springjpashop.dto.Patch;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchMemberStarResponseDto {

    private String userId;
    private byte starRating;
}
