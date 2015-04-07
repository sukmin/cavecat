package com.cavecat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cavecat.controller.BoardController;
import com.cavecat.controller.BoardListController;
import com.cavecat.controller.BoardSaveController;
import com.cavecat.controller.BoardViewController;
import com.cavecat.controller.Controller;
import com.cavecat.controller.LoginCertifyController;
import com.cavecat.controller.LoginController;
import com.cavecat.controller.LogoutController;
import com.cavecat.controller.SessionListController;
import com.cavecat.dao.BoardDAO;
import com.cavecat.model.Board;
import com.cavecat.model.User;

public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

  public static final String REDIRECT = "redirect:";
  public static final String HTTP_REQUEST = "httpRequest";
  public static final String HTTP_SESSION = "httpSession";
  public static final String SERVLET_CONTEXT = "servletContext";

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");

    Controller controller = null;
    String servletPath = request.getServletPath();
    HttpSession session = request.getSession();
    Map<String, Object> model = new HashMap<>();

    ServletContext sc = this.getServletContext();
    JdbcTemplate jdbcTemplate = (JdbcTemplate) sc.getAttribute("jdbcTemplate");
    BoardDAO boardDAO = new BoardDAO();
    boardDAO.setJdbcTemplate(jdbcTemplate);


    logger.info("servletPath : {}", servletPath);

    try {

      switch (servletPath) {
        case "/":
        case "/login":
          model.put(User.PARAM_ID, session.getAttribute(User.PARAM_ID));
          controller = new LoginController();
          break;
        case "/loginCertify":
          model
              .put(
                  User.USER,
                  new User(request.getParameter(User.PARAM_ID), request
                      .getParameter(User.PARAM_PASSWD)));
          model.put(HTTP_REQUEST, request);
          controller = new LoginCertifyController();
          break;
        case "/list":
          model.put(SERVLET_CONTEXT, this.getServletContext());
          model.put(Board.BOARDS, this.getServletContext().getAttribute(Board.BOARDS));
          BoardListController b = new BoardListController();
          b.setBoardDAO(boardDAO);
          controller = b;
          break;
        case "/board":
          controller = new BoardController();
          break;
        case "/view":
          model.put(Board.BOARDS, this.getServletContext().getAttribute(Board.BOARDS));
          model.put(Board.PARAM_ID, request.getParameter(Board.PARAM_ID));
          BoardViewController b1 = new BoardViewController();
          b1.setBoardDAO(boardDAO);
          controller = b1;
          break;
        case "/boardSave":
          model.put(
              Board.BOARD,
              new Board(request.getParameter(Board.PARAM_TITLE), request
                  .getParameter(Board.PARAM_TEXT)));
          BoardSaveController b2 = new BoardSaveController();
          b2.setBoardDAO(boardDAO);
          controller = b2;
          break;
        case "/logout":
          model.put(HTTP_SESSION, session);
          controller = new LogoutController();
          break;
        case "/session":
          controller = new SessionListController();
          break;
        default:
          throw new Exception("정의되지 않은 URL");
      }

      String viewUrl = controller.execute(model);
      model.keySet().forEach((key) -> request.setAttribute(key, model.get(key)));

      if (viewUrl.startsWith(REDIRECT)) {
        response.sendRedirect(viewUrl.substring(9));
        return;
      }

      RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
      rd.include(request, response);

    } catch (Exception e) {
      logger.debug("DispatcherServlet Exception: {}", e.getMessage());
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
      rd.forward(request, response);
    }
  }
}
