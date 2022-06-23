package com.board;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.board.paging.Criteria;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.List;


@SpringBootTest
public class MapperTests {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testOfInsert() {
        BoardDTO params = new BoardDTO();
        params.setTitle("게시글 제목 테스트");
        params.setContent("게시글 내용 테스트");
        params.setWriter("신승록");

        int result = boardMapper.insertBoard(params);
        System.out.println("테스트 결과는 " + result + "입니다");
    }

    @Test
    public void testOfSelectDetail() {
        //인자로 지정된 (long) 1은 앞에서 추가한 1번 게시글의 PK에 해당하는 idx를 의미합니다.
        BoardDTO board = boardMapper.selectBoardDetail((long) 1);
        try {
            //String boardJson = new ObjectMapper().writeValueAsString(board);
            String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
            System.out.println("===========================");
            System.out.println(boardJson);
            System.out.println("===========================");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

        @Test
        public void testOfUpdate() {
            BoardDTO params = new BoardDTO();
            params.setTitle("1번 게시글 제목을 수정합니다.");
            params.setContent("1번 게시글 내용을 수정합니다.");
            params.setWriter("홍길동dd");
            params.setIdx((long) 1);

            int result = boardMapper.updateBoard(params);
            if (result == 1) {
                BoardDTO board = boardMapper.selectBoardDetail((long) 1);
                try {
                    //String boardJson = new ObjectMapper().writeValueAsString(board);
                    String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);

                    System.out.println("=========================");
                    System.out.println(boardJson);
                    System.out.println("=========================");

                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }

    @Test
    public void testOfDelete() {
        int result = boardMapper.deleteBoard((long) 1);
        if (result == 1) {
            BoardDTO board = boardMapper.selectBoardDetail((long) 1);
            try {
                //String boardJson = new ObjectMapper().writeValueAsString(board);
                String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);

                System.out.println("=========================");
                System.out.println(boardJson);
                System.out.println("=========================");

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testMultipleInsert() {
        for(int i = 2; i <= 50; i++) {
              BoardDTO params = new BoardDTO();
            params.setTitle(i + "번 게시글 제목");
            params.setContent(i + "번 게시글 내용");
            params.setWriter(i + "번 게시글 작성자");
            boardMapper.insertBoard(params);
        }
    }

   /* @Test
    public void testSelectList(Criteria criteria) {
            int boardTotalCount = boardMapper.selectBoardTotalCount(criteria);
            if (boardTotalCount > 0) {
                    List<BoardDTO> boardList = boardMapper.selectBoardList(criteria);
                    if (CollectionUtils.isEmpty(boardList) == false) {
                        for (BoardDTO board : boardList) {
                            System.out.println("==========================");
                            System.out.println(board.getTitle());
                            System.out.println(board.getContent());
                            System.out.println(board.getWriter());
                            System.out.println("===========================");
                        }
                    }
            }
    }*/
}
