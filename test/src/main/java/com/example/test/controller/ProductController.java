package com.example.test.controller;

import com.example.test.domain.vo.ProductVO;
import com.example.test.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/*")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    //목록
    @GetMapping("list")
    public void list(Model model){
        model.addAttribute("products", productService.show());
    }

    //추가 (1개)
    @GetMapping("write")    //글 작성 페이지 가져와서
    public void write(){}

    @PostMapping("write")   //글 작성 후 DB에 전송, 메소드 오버로딩
    public void write(ProductVO productVO){
        productService.add(productVO);
    }

    //수정
    @GetMapping("update")
    public void update(){}

    @PostMapping("update")
    public void udpate(ProductVO productVO){
        productService.update(productVO);z
    }
}
