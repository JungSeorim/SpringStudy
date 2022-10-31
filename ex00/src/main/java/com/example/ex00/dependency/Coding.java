package com.example.ex00.dependency;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Data
@Getter
//@Setter                   //안 만들어 놓고 필요할 때 추가하는 게 맞다
//@NoArgsConstructor          //기본생성자
//@AllArgsConstructor         //전체 초기화생성자
@RequiredArgsConstructor    //원하는 필드만 초기화하는 생성자
@ToString
public class Coding {
//    필드 주입
//    굉장히 편하게 주입할 수 있으나 순환참조(무한반복)시 오류가 발생하지 않기 때문에 StackOverFlow(아주 심각한 오류) 발생
//    Final을 붙일 수 없기 때문에 다른 곳에서 변형 가능
//    @Autowired
//    필드주입은 웬만해선 피하지만 이 경우 생성자때문에 오류가 나지않음
//    의존관계에 있는 것들만 final
    private final Computer computer;

//    생성자 주입
//    순환참조시 컴파일러 인지 가능, 오류 발생
//    메모리에 할당되면서 초기값으로 주입되므로 final키워드 사용간으, 다른 곳에서 변형 불가능
//    의존성 주입이 되지 않으면 객체가 생성되지 않으므로 NPE방어
//    생성자에 @Autowired 생략가능
//    @Autowired
//    public Coding(Computer computer) {
//        this.computer = computer;
//    }
}
