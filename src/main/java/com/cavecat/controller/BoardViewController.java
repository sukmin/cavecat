package com.cavecat.controller;

import java.util.Map;

import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;

import com.cavecat.dao.BoardDAO;
import com.cavecat.model.Board;

public class BoardViewController implements Controller {
  private BoardDAO boardDAO;

  public void setBoardDAO(BoardDAO boardDAO) {
    this.boardDAO = boardDAO;
  }

  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Long id = Long.parseLong((String) model.get(Board.PARAM_ID));

    Board board = boardDAO.selectOne(id);
    PegDownProcessor processor = new PegDownProcessor(Extensions.ALL);
    board.setText(processor.markdownToHtml(board.getText()));

    model.put(Board.BOARD, board);

    return "/WEB-INF/jsp/board/view.jsp";
  }
}
