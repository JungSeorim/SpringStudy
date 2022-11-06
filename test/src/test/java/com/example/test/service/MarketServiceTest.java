package com.example.test.service;

import com.example.test.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MarketServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void showTest(){
        productService.show();
    }
    @Test
    public void findTest(){
        productService.find(2);
    }
    @Test
    public void addTest(){
        ProductVO productVO = new ProductVO();
        productVO.setProductPrice(1440000);
        productVO.setProductProducers("아무거나");
        productVO.setProductName("암거나 넣기");

        productService.add(productVO);
    }
    @Test
    public void updateTest(){
        ProductVO productVO = productService.find(10);
        productVO.setProductName("수정완료");
        productVO.setProductProducers("수정완료");
        productVO.setProductPrice(1111111);

        productService.update(productVO);
    }
    @Test
    public void deleteTest(){
        log.info("아무거나 삭제완료");
        productService.delete(10);
    }


}
