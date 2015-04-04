package com.cavecat.controller;

import java.util.Map;

import com.cavecat.listener.SessionRegistry;

public class SessionListController implements Controller {

  @Override
  public String execute(Map<String, Object> model) throws Exception {

    model.put("numberOfSessions", SessionRegistry.getNumberOfSessions());
    model.put("sessionList", SessionRegistry.getAllSessions());
    return "/WEB-INF/jsp/board/sessions.jsp";
  }

}
