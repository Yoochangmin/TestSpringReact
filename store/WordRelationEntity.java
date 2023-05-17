package jpabook.springjpashop.Entity;


import jpabook.springjpashop.dto.WordRelationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "word_relation")
@Table(name = "word_relation")
public class WordRelationEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="word_id")
    private Long id;

    private String string;

    public WordRelationEntity(WordRelationDto dto){
        this.id = dto.getId();
        this.string = dto.getString();
    }
}
