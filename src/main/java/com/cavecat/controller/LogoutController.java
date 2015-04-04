package com.cavecat.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.cavecat.DispatcherServlet;

public class LogoutController implements Controller {

  @Override
  public String execute(Map<String, Object> model) throws Exception {

    HttpSession serssion = (HttpSession) model.get(DispatcherServlet.HTTP_SESSION);

    serssion.invalidate();

    return DispatcherServlet.REDIRECT + "/login";
  }



}
