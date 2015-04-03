package com.cavecat.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cavecat.model.Board;

public class BoardServlet extends HttpServlet {
  private static final long serialVersionUID = 4251285399811752982L;
  private static Logger logger = LoggerFactory.getLogger(BoardServlet.class);

  @Override
  public void destroy() {
    logger.debug("Servlet {} has stopped.", this.getServletName());
  }

  @Override
  public void init() throws ServletException {
    logger.debug("Servlet {} has started.", this.getServletName());
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {

    HttpSession session = req.getSession();


    // 모든 서블릿에서 공유하는 값
    ServletContext servletContext = this.getServletContext();
    System.out.println(servletContext.getInitParameter("movie"));
    System.out.println(servletContext.getInitParameter("game"));

    // 해당 서블릿에서만 사용할 수 있는 값
    ServletConfig servletConfig = this.getServletConfig();
    System.out.println(servletConfig.getInitParameter("bookStore"));
    System.out.println(servletConfig.getInitParameter("gameSite"));

    session.setAttribute("apple", "jobs");
    System.out.println(session.getId());

    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/board/board.jsp");
    requestDispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {
    appendBoardByServletContext(req);

    resp.sendRedirect("/list");
  }

  /**
   * TODO: 영속성을 위해 임시로 추가한 부분<br>
   * DB를붙이면 삭제 요망
   * 
   * @param req
   */
  private void appendBoardByServletContext(HttpServletRequest req) {
    ServletContext servletContext = this.getServletContext();
    @SuppressWarnings("unchecked")
    List<Board> boards = (List<Board>) servletContext.getAttribute("boards");

    Board board = new Board();
    board.setId(boards.size() + 1L);
    board.setTitle(req.getParameter("title"));
    board.setText(req.getParameter("text"));

    boards.add(board);
    servletContext.setAttribute("boards", boards);
  }
}
