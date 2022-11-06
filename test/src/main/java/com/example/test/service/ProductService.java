package com.example.test.service;

import com.example.test.dao.ProductDAO;
import com.example.test.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    //전체조회
    public List<ProductVO> show();

    //조회
    public ProductVO find(int productNumber);

    //추가
    public void add(ProductVO productVO);

    //수정
    public void update(ProductVO productVO);

    //삭제
    public void delete(int productNumber);
}
