package com.cavecat.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cavecat.dao.BoardDAO;
import com.cavecat.model.Board;

public class BoardListController implements Controller {
  private static Logger logger = LoggerFactory.getLogger(BoardListController.class);

  private BoardDAO boardDAO;

  public void setBoardDAO(BoardDAO boardDAO) {
    this.boardDAO = boardDAO;
  }

  @Override
  public String execute(Map<String, Object> model) throws Exception {
    List<Board> boards = boardDAO.selectList();
    boards = sortBoardList(boards);
    logger.info("현재 보드 갯수 : {}", boards.size());

    model.put(Board.BOARDS, boards);
    return "/WEB-INF/jsp/board/list.jsp";
  }

  private List<Board> sortBoardList(List<Board> boards) {
    return boards.stream(). //
        sorted((e1, e2) -> Long.compare(e2.getSequence(), e1.getSequence())) //
        .collect(Collectors.toList());
  }
}
