package com.example.test.dao;

import com.example.test.domain.vo.ProductVO;
import com.example.test.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAO {

    private final ProductMapper productMapper;

    //전체 조회
    public List<ProductVO> findAll(){
        return productMapper.selectAll();
    }

    //조회
    public ProductVO findById(int productNumber){
        return productMapper.select(productNumber);
    }

    //추가
    public void save(ProductVO productVO){
        productMapper.insert(productVO);
    }

    //수정
    public void update(ProductVO productVO){
        productMapper.update(productVO);
    }

    //삭제
    public void deleteById(int productNumber){
        productMapper.delete(productNumber);
    }
}
