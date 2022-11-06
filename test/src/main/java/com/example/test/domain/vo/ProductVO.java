package com.example.test.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductVO {
    private int productNumber;
    private String productName;
    private String productProducers;
    private int productPrice;
    private int productRegisterDate;
    private int productUpdateDate;
}
