package com.cavecat.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cavecat.DispatcherServlet;
import com.cavecat.dao.BoardDAO;
import com.cavecat.model.Board;

public class BoardSaveController implements Controller {
  private static Logger logger = LoggerFactory.getLogger(BoardSaveController.class);
  private BoardDAO boardDAO;

  public void setBoardDAO(BoardDAO boardDAO) {
    this.boardDAO = boardDAO;
  }

  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Board board = (Board) model.get(Board.BOARD);
    logger.info(board.toString());

    board = boardDAO.insertOne(board);
    return DispatcherServlet.REDIRECT + "/view?id=" + board.getSequence();
  }
}
