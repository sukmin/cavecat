package com.cavecat.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
  private String redirectPath = "/";

  public void setRedirectPath(String redirectPath) {
    this.redirectPath = redirectPath;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    HttpSession session = request.getSession();
    if (Objects.isNull(session.getAttribute("id"))) {
      response.sendRedirect(redirectPath);
      return false;
    }

    return true;
  }
}
