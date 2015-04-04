package com.cavecat.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cavecat.listener.SessionRegistry;

public class SessionListServlet extends HttpServlet {
  private static final long serialVersionUID = -5488872651575949633L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {

    if (req.getSession().getAttribute("id") == null) {
      resp.sendRedirect("/board/login");
      return;
    }

    req.setAttribute("numberOfSessions", SessionRegistry.getNumberOfSessions());
    req.setAttribute("sessionList", SessionRegistry.getAllSessions());
    req.getRequestDispatcher("/WEB-INF/jsp/board/sessions.jsp").forward(req, resp);;
  }
}
