package com.cavecat.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.cavecat.bo.BoardBO;
import com.cavecat.model.Board;
import com.cavecat.model.User;

@Controller
public class BoardController {
  private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

  private BoardBO boardBO;

  @Autowired
  public BoardController(BoardBO boardBO) {
    this.boardBO = boardBO;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView home() {
    return list();
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView("/board/list");
    mav.addObject(Board.BOARDS, boardBO.getBoardes());
    return mav;
  }

  @RequestMapping(value = "/{sequence}", method = RequestMethod.GET)
  public ModelAndView read(@PathVariable Long sequence) {
    ModelAndView mav = new ModelAndView("/board/read");
    logger.debug("board id by {}", sequence);

    Board board = boardBO.getBoard(sequence);


    mav.addObject(Board.BOARD, board);

    return mav;
  }

  @RequestMapping(value = "/write", method = RequestMethod.GET)
  public ModelAndView write() {
    return new ModelAndView("/board/form");
  }

  @RequestMapping(value = "/write", method = RequestMethod.POST)
  public ModelAndView write(@Valid @ModelAttribute Board board, BindingResult BindingResult,
      HttpSession session) {

    String id = (String) session.getAttribute(User.PARAM_ID);
    board.setRegistor(id);
    board.setModifier(id);

    ModelAndView mav = new ModelAndView();
    if (BindingResult.hasErrors()) {
      mav.addObject("board", board);
      mav.setViewName("/board/form");
      return mav;
    }

    Long sequence = boardBO.addBoard(board);
    mav.setViewName("redirect:/" + sequence);

    return mav;
  }
}
