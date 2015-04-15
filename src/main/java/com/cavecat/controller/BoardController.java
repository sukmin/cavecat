package com.cavecat.controller;

import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cavecat.dao.BoardDAO;
import com.cavecat.model.Board;

@Controller
public class BoardController {
  private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

  @Autowired
  private BoardDAO boardDAO;

  public void setBoardDAO(BoardDAO boardDAO) {
    this.boardDAO = boardDAO;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView home() {
    return list();
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView("/board/list");
    mav.addObject(Board.BOARDS, boardDAO.selectList());
    return mav;
  }

  @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
  public ModelAndView read(@PathVariable Long id) {
    ModelAndView mav = new ModelAndView("/board/read");
    logger.debug("board id by {}", id);

    Board board = boardDAO.selectOne(id);
    PegDownProcessor processor = new PegDownProcessor(Extensions.ALL);
    board.setText(processor.markdownToHtml(board.getText()));
    mav.addObject(Board.BOARD, board);

    return mav;
  }

  @RequestMapping(value = "/write", method = RequestMethod.GET)
  public ModelAndView write() {
    return new ModelAndView("/board/form");
  }

  @RequestMapping(value = "/write", method = RequestMethod.POST)
  public RedirectView write(@ModelAttribute Board board) {
    board = boardDAO.insertOne(board);
    return new RedirectView("/read/" + board.getSequence());
  }
}
