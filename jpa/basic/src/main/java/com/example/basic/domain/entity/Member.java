package com.example.basic.domain.entity;


import com.example.basic.type.MemberType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity /*JPA등록*/
@Getter
@Setter
@ToString
@Table(name = "TBL_MEMBER") /*테이블명 설정,안하면 디폴트값이 클래스명*/
public class Member {

    /*PK설정,SEQ설정*/
    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID") /*자바에서는 캐멀표기법이니까 이렇게 오라클에 들어갈 이름으로 바까준다.*/
    private Long memberId;
    @Column(name="MEMBER_NAME")
    private String memberName;
    @Column(name="MEMBER_EMAIL", unique=true)
    private String memberEmail;
    @Column(name="MEMBER_PASSWORD")
    private String memberPassword;
    @Column(name="MEMBER_AGE")
    private int memberAge;
    @Column(name="MEMBER_TYPE")
    private MemberType memberType; /*enum을 만들었다.*/
//    @Column(name="MEMBER_GENDER")
//    private MemberType memberGender;

    /*여기까지 테이블 생성*/
}