package jpabook.springjpashop;


import jpabook.springjpashop.Entity.MindMap.MindMapEdge;
import jpabook.springjpashop.Entity.MindMap.MindMapEntity;
import jpabook.springjpashop.Entity.MindMap.MindMapNode;
import jpabook.springjpashop.repository.MindMapRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MindMapTests {
    @Autowired
    MindMapRepository mindMapRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    public void mapping(){
        MindMapNode mindMapNode =new MindMapNode();
        MindMapEdge mindMapEdge = new MindMapEdge();

        mindMapNode.setId("1");
        mindMapNode.setLabel("선풍기");
        mindMapNode.setType("level1");

        mindMapEdge.setId("1->2");
        mindMapEdge.setSource("2");
        mindMapEdge.setTarget("1");

        MindMapEntity mindMapEntity = new MindMapEntity();
//        mindMapEntity.setMindMapNode(mindMapNode);
//        mindMapEntity.setMindMapEdge(mindMapEdge);

        em.persist(mindMapEntity);
    }

}
