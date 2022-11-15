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
@Table(name = "TBL_SUPER_CAR") /*테이블명 설정,안하면 디폴트값이 클래스명*/
public class SuperCar {

    /*PK설정,SEQ설정*/
    @Id
    @GeneratedValue
    @Column(name="SUPER_CAR_ID") /*자바에서는 캐멀표기법이니까 이렇게 오라클에 들어갈 이름으로 바꿔준다.*/
    private Long superCarId;

    @Column(name="SUPER_CAR_BRAND")
    private String superCarBrand;

    @Column(name="SUPER_CAR_NAME")
    private String superCarName;

    @Column(name="SUPER_CAR_COLOR")
    private String superCarColor;
    
    @Column(name="SUPER_CAR_PRICE")
    private Long superCarPrice;
}
