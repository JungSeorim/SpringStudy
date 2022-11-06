package com.example.test.dao;

import com.example.test.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductDAOTest {
    @Autowired
    private ProductDAO productDAO;

    //전체 조회
    @Test
    public void findAllTest(){
        productDAO.findAll();
    }

    //조회
    @Test
    public void findByIdTest(){
        int productNumber = 2;
        productDAO.findById(2);
    }

    //추가
    @Test
    public void saveTest(){
        ProductVO productVO = new ProductVO();

        productVO.setProductName("노트북");
        productVO.setProductPrice(1500000);
        productVO.setProductProducers("DELL");

        productDAO.save(productVO);
    }

    //수정
    @Test
    public void updateTest(){
        ProductVO productVO = productDAO.findById(6);

        productVO.setProductName("수정TV");
        productVO.setProductProducers("수정LG");
        productVO.setProductPrice(productVO.getProductPrice()+3000);

        productDAO.update(productVO);
    }

    //삭제
    @Test
    public void deleteByIdTest(){
        int productNumber = 6;
        productDAO.deleteById(productNumber);
    }
}
