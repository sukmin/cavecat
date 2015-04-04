package com.cavecat.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cavecat.DispatcherServlet;
import com.cavecat.model.User;

public class LoginCertifyController implements Controller {

  private static final Set<User> userData = new HashSet<>();

  static {

    userData.add(new User("killroad", "killroad"));
    userData.add(new User("serivires", "serivires"));

  }

  @Override
  public String execute(Map<String, Object> model) throws Exception {

    User user = (User) model.get(User.USER);

    if (isLoginSuccess(user)) {

      HttpServletRequest request = (HttpServletRequest) model.get(DispatcherServlet.HTTP_REQUEST);
      HttpSession session = request.getSession();
      session.setAttribute(User.PARAM_ID, user.getId());

      // 세션 고정 공격 방지 http://storyj.net/?p=52
      request.changeSessionId();

      return DispatcherServlet.REDIRECT + "/list";

    } else {

      model.put(User.PARAM_LOGIN_FAILED, true);
      return "/WEB-INF/jsp/board/login.jsp";

    }

  }

  private boolean isLoginSuccess(User user) {
    return userData.contains(user);
  }

}
