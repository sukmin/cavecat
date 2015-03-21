package com.cavecat.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {
  private static final long serialVersionUID = -777319181324364299L;
  private static final List<Map<String, Object>> lists = new ArrayList<>();

  static {
    lists.add(getBoard("5", "별 하나에 시와"));
    lists.add(getBoard("4", "별 하나에 동경과"));
    lists.add(getBoard("3", "별 하나에 쓸쓸함과"));
    lists.add(getBoard("2", "별 하나에 사랑과"));
    lists.add(getBoard("1", "별 하나에 추억과"));
  }

  private static Map<String, Object> getBoard(String id, String title) {
    Map<String, Object> board = new HashMap<>();
    board.put("id", id);
    board.put("title", title);
    return board;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {
    resp.setCharacterEncoding("utf-8");
    req.setAttribute("lists", lists);

    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/board/list.jsp");
    requestDispatcher.forward(req, resp);
  }
}
