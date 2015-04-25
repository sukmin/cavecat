package com.cavecat.controller;

import javax.validation.Valid;

import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

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
    mav.addObject(Board.BOARDS, boardDAO.selectAll());
    return mav;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ModelAndView read(@PathVariable Long id) {
    ModelAndView mav = new ModelAndView("/board/read");
    logger.debug("board id by {}", id);

    Board board = boardDAO.select(id);
    board.setTitle(HtmlUtils.htmlEscape(board.getTitle(), "utf-8"));
    PegDownProcessor processor = new PegDownProcessor(Extensions.ALL);
    board.setText(processor.markdownToHtml(HtmlUtils.htmlEscape(board.getText(), "utf-8")));
    mav.addObject(Board.BOARD, board);

    return mav;
  }

  @RequestMapping(value = "/write", method = RequestMethod.GET)
  public ModelAndView write() {
    return new ModelAndView("/board/form");
  }

  @RequestMapping(value = "/write", method = RequestMethod.POST)
  public ModelAndView write(@Valid @ModelAttribute Board board, BindingResult BindingResult) {
    ModelAndView mav = new ModelAndView();
    if (BindingResult.hasErrors()) {
      mav.addObject("board", board);
      mav.setViewName("/board/form");
      return mav;
    }

    Long sequence = boardDAO.insert(board);
    mav.setViewName("redirect:/" + sequence);

    return mav;
  }
}
