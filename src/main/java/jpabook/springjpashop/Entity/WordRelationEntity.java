package jpabook.springjpashop.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "WordRelation")
@Table(name = "WordRelation")
public class WordRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="word_relation_id")
    private Long id;

    private String rootWord;

    private String word;
}
