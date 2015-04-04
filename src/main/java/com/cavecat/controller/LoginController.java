package com.cavecat.controller;

import java.util.Map;
import java.util.Objects;

import com.cavecat.DispatcherServlet;
import com.cavecat.model.User;

public class LoginController implements Controller {

  @Override
  public String execute(Map<String, Object> model) throws Exception {

    if (Objects.nonNull(model.get(User.PARAM_ID))) {
      return DispatcherServlet.REDIRECT + "/list";
    }

    model.put("loginFailed", false);
    return "/WEB-INF/jsp/board/login.jsp";
  }

}
