package com.example.ex02.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {
    private String id;
    private String password;
//    private String pw;    //input태그 name값과 같아야함
}
