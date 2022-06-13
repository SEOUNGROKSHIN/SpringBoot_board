package com.board.service;

import com.board.domain.BoardDTO;

import java.util.List;

public interface BoardService {

    public boolean registerBoard(BoardDTO params);

    public BoardDTO getBoardDetail(long idx);

    public boolean deleteBoard(Long idx);

    public List<BoardDTO> getBoardList();
}
