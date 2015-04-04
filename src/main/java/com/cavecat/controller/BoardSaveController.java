package com.cavecat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cavecat.DispatcherServlet;
import com.cavecat.model.Board;

public class BoardSaveController implements Controller {

  private static Logger logger = LoggerFactory.getLogger(BoardSaveController.class);

  @Override
  public String execute(Map<String, Object> model) throws Exception {

    ServletContext servletContext = (ServletContext) model.get(DispatcherServlet.SERVLET_CONTEXT);
    Board board = (Board) model.get(Board.BOARD);

    @SuppressWarnings("unchecked")
    List<Board> boards = (List<Board>) servletContext.getAttribute(Board.BOARDS);
    if (Objects.isNull(boards)) {
      boards = new ArrayList<>();
    }
    board.setId(boards.size() + 1L);
    boards.add(board);

    logger.info(board.toString());

    servletContext.setAttribute(Board.BOARDS, boards);

    return DispatcherServlet.REDIRECT + "/view?id=" + board.getId();
  }

}
