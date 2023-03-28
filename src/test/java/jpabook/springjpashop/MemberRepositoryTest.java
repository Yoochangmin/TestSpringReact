package jpabook.springjpashop;

import jpabook.springjpashop.domain.Member;
import jpabook.springjpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
    @SpringBootTest
public class MemberRepositoryTest {
}//
//        @Autowired
//        MemberRepository memberRepository;
//
//        @Test
//        @Transactional
//        @Rollback(value = false)
//        public void testMember() throws Exception{
////            //given
////            Member member = new Member();
////            member.setUsername("memberA");
////
////            //when
////            Long saveId = memberRepository.save(member);
////            Member findMember = memberRepository.find(saveId);
////
//            then
////            Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
////            Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//            findMember의 getUsername이랑 member의 getUsername이랑 같은지?
////        }
//
//}