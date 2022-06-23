package com.board.mapper;

import java.util.List;

import com.board.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import com.board.domain.BoardDTO;

@Mapper
public interface BoardMapper {

    public int insertBoard(BoardDTO params);

    public BoardDTO selectBoardDetail(Long idx);

    public int updateBoard(BoardDTO params);

    public int deleteBoard(Long idx);

    public List<BoardDTO> selectBoardList(Criteria criteria);

    public int selectBoardTotalCount(Criteria criteria);

}