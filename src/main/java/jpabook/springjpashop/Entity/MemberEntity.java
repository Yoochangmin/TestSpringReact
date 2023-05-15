package jpabook.springjpashop.Entity;

import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.dto.MemberDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "Member")
@Table(name = "Member")
public class MemberEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="member_id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "mind_map_id")
    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL)
    private List<MindMapEntity> mindMap = new ArrayList<>();


    public void addMindMap(MindMapEntity mindMapEntity){
        mindMap.add(mindMapEntity);
        mindMapEntity.setMemberEntity(this);
    }

    public MemberEntity(MemberDto dto){
        this.userId = dto.getUserId();
        this.userEmail=dto.getUserEmail();
        this.userPassword = dto.getUserPassword();
        this.mindMap = dto.getMindMap();
//        this.
//        this.memberLike= dto.getMemberLike();
    }

}

