package com.example.test.mapper;

import com.example.test.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void selectAllTest(){
        productMapper.selectAll();

        //toString으로 하려면
        log.info("여기 toString으로 !");
        productMapper.selectAll().stream().map(ProductVO::toString).forEach(log::info);

    }

    @Test
    public void insertTest(){
        ProductVO productVO = new ProductVO();

        //일부러 오류를 발생시켜 null이 아님을 확인시켜준다
        //빨간 글씨가 나와도 오류가 아님!!
        Assertions.assertNotNull(productVO);

        productVO.setProductName("TV");
        productVO.setProductPrice(2000000);
        productVO.setProductProducers("LG");
        productMapper.insert(productVO);

    }

    @Test
    public void selectTest(){
        ProductVO productVO = productMapper.select(2);
    }

    @Test
    public void updateTest(){
        //해당 게시글 번호를 불러와서
        //저장해준 뒤
        ProductVO productVO = productMapper.select(2);

        //바꿔서 모델객체에 저장
        productVO.setProductProducers("LG");
        productVO.setProductName("컴퓨터");
        productVO.setProductPrice(1200000);

        //update()까지 실행시켜주면 끝
        productMapper.update(productVO);
    }

    @Test
    public void deleteTest(){
        //삭제실행
        productMapper.delete(3);
    }
}
