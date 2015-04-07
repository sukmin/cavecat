package com.cavecat.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cavecat.model.Board;

public class ListServlet extends HttpServlet {
  private static final long serialVersionUID = -777319181324364299L;
  private static Logger logger = LoggerFactory.getLogger(ListServlet.class);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {

    setBoardsByServletRequest(req);

    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/board/list.jsp");
    requestDispatcher.forward(req, resp);
  }

  /**
   * TODO: 영속성을 위해 임시로 추가한 부분<br>
   * DB를붙이면 삭제 요망
   * 
   * @param req
   */
  private void setBoardsByServletRequest(HttpServletRequest req) {
    @SuppressWarnings("unchecked")
    List<Board> boards = (List<Board>) this.getServletContext().getAttribute("boards");
    if (boards == null) {
      boards = new ArrayList<Board>();
      this.getServletContext().setAttribute("boards", boards);
    }

    boards =
        boards.stream().sorted((e1, e2) -> Long.compare(e2.getSequence(), e1.getSequence()))
            .collect(Collectors.toList());
    req.setAttribute("boards", boards);
  }
}
