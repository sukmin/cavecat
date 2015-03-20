package com.cavecat.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {

      if(req.getSession().getAttribute("id") == null){
        resp.sendRedirect("/board/login");
        return;
      }
      
      req.setAttribute("numberOfSessions", SessionRegistry.getNumberOfSessions());
      req.setAttribute("sessionList", SessionRegistry.getAllSessions());
      req.getRequestDispatcher("/WEB-INF/jsp/board/sessions.jsp").forward(req, resp);;

  }



}
