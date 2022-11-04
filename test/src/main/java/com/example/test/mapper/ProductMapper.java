package com.example.test.mapper;

import com.example.test.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public List<ProductVO> selectAll();

    public ProductVO select(int productNumber);

    public int insert(ProductVO productVO);

    public int update(ProductVO productVO);

    public int delete(int productNumber);

}
