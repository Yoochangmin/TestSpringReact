package jpabook.springjpashop.dto.MindMap;

import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import lombok.*;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MindMapNodeDto {

    private String id;
    private String label;
    private String type;



    @Override
    public String toString() {
        return "MindMapNode [id=" + id + ", label=" + label + ", type=" +type + "]";
    }
}
