package jpabook.springjpashop;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
    @SpringBootTest
public class MemberEntityRepositoryTest {
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