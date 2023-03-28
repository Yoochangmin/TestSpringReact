package jpabook.springjpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter
public class Member {
    @Id @GeneratedValue
    @Column(name ="member_id")
    private Long id;

    @Column(name = "login_id")
    private String userId;

    private String name;

    @Column(name = "member_email")
    private String email;

    private String password;

}
