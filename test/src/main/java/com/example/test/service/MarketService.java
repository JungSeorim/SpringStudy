package com.example.test.service;

import com.example.test.dao.ProductDAO;
import com.example.test.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketService implements ProductService{
    private final ProductDAO productDAO;

    @Override
    public List<ProductVO> show() {
        return productDAO.findAll();
    }

    @Override
    public ProductVO find(int productNumber) {
        return productDAO.findById(productNumber);
    }

    @Override
    public void add(ProductVO productVO) {
        productDAO.save(productVO);
    }

    @Override
    public void update(ProductVO productVO) {
        productDAO.update(productVO);
    }

    @Override
    public void delete(int productNumber) {
        productDAO.deleteById(productNumber);
    }


}
