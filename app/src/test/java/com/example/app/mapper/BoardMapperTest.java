package com.example.app.mapper;

import com.example.app.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void getListTest(){
        boardMapper.getList().stream().map(BoardVO::toString).forEach(log::info);
    }

    // 추가
    @Test
    public void insert(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardNumber(100l);
        boardVO.setBoardTitle("추가제목");
        boardVO.setBoardContent("추가내용");
        boardVO.setBoardWriter("추가작성자");
        boardMapper.insert(boardVO);
    }

    // 수정
    @Test
    public void update(){
        BoardVO boardVO = boardMapper.select(9L);
        Assertions.assertNotNull(boardVO);
        boardVO.setBoardWriter("작성자 수정완료");
        boardVO.setBoardContent("내용 수정완료");
        boardVO.setBoardTitle("제목 수정완료");
        boardMapper.update(boardVO);
    }

    // 삭제
    @Test
    public void delete(){
        BoardVO boardVO = boardMapper.select(9L);
        Assertions.assertNotNull(boardVO);
        boardMapper.delete(9L);
    }


}
