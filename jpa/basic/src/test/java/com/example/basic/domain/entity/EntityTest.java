package com.example.basic.domain.entity;

import com.example.basic.type.MemberType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class EntityTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional  //transaction 시작 begin() > 쿼리등록 persist() >쿼리 발동 flush() > 반영? commit() : 이 과정을 해줌
    @Rollback(false)    //커밋이 안됨
    public void memberTest(){
        Member memberA = new Member();
        Member memberB = new Member();

        memberA.setMemberName("한동석");
        memberA.setMemberEmail("tedhan1204@gmail.com");
        memberA.setMemberPassword("1234");
        memberA.setMemberAge(20);
        memberA.setMemberType(MemberType.MEMBER);

        memberB.setMemberName("장선홍");
        memberB.setMemberEmail("jsh0419@gmail.com");
        memberB.setMemberPassword("5060");
        memberB.setMemberAge(20);
        memberB.setMemberType(MemberType.ADMIN);

//        영속성 컨텍스트에 등록, 1차 캐시에 저장(DB 저장X)
        entityManager.persist(memberA);
        entityManager.persist(memberB);

//        영속성 컨텍스트에 등록된 정보를 SQL로 방출, 캐시는 그대로 유지
//        원래 flush()는 커밋 전에 발동된다.
        entityManager.flush();

//        영속성 컨텍스트에 있는 1차 캐시를 없애준다.
        entityManager.clear();

//        캐시에 해당 ID가 있다면 SQL 조회 없이 캐시에서 가져온다(성능 최적화)
        Member findMember1 = entityManager.find(Member.class, 1L);

//        entityManager.flush();    //flush에 저장되지 않은 것을 한번더 날려준다(?) : 비워주는 것이 아님
//        entityManager.clear();    //캐시에 있는 것을 비워준다

        Member findMember2 = entityManager.find(Member.class, 1L);

//        더티 체킹 : 상태의 변화를 감지하고 알아서 반영
//        최초 조회 상태의 스냅샷과 트랜잭션이 끝난 시점을 비교하여 다른 점이 있다면 Update쿼리를 DB에 반영
        findMember2.setMemberPassword("0000");

//        entityManager.flush();
//        entityManager.clear();

//        삭제를 할 경우 영속상태(1차 캐시 등록X)인 객체만 가능하다.
        entityManager.remove(findMember2);

        entityManager.flush();
        entityManager.clear();

        if(Optional.ofNullable(findMember1).isPresent()){
            assertThat(findMember1.getMemberEmail()).isEqualTo("tedhan1204@gmail.com");
//            SELECT 쿼리 flush 후 1차 캐시에 저장된 객체를 다시 조회하면 값 비교는 항상 true이다.
            assertThat(findMember1).isEqualTo(findMember2);
        }
    }
}















