package com.cavecat.controller;

import java.util.Map;

public class BoardController implements Controller {

  @Override
  public String execute(Map<String, Object> model) throws Exception {
    return "/WEB-INF/jsp/board/board.jsp";
  }

}
