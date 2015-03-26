package com.cavecat.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Objects;

public class LoginServlet extends HttpServlet {


  private static Logger logger = LoggerFactory.getLogger(LoginServlet.class);
  private static final long serialVersionUID = 9222155466231723860L;
  private static final Map<String, String> userData = new HashMap<>();

  static {
    userData.put("serivires", "serivires");
    userData.put("killroad", "killroad");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {

    logger.info("로그인페이지 doGet");

    // <Manager className="org.apache.catalina.session.PersistentManager"
    // saveOnRestart="true"/>
    //
    // Tomcat 서버를 재시동하거나 심지어 컴퓨터를 껐다 켜도 기존의 세션이 백업이 된다.
    // 일정시간 사용되지 않는 세션은 하드에 저장되어 메모리를 차지하지 않게 된다.
    // 그러다 다시 그 세션의 요청이 들어오면 복원된다.
    // 톰캣을 셧다운할 때에 현재 있는 모든 세션이 저장된다.
    // 기본설정은 true.
    HttpSession session = req.getSession();

    if (req.getParameter("logout") != null) {
      session.invalidate();
      resp.sendRedirect("/login");
      return;
    }

    // 로그인이 이미 되어있는 경우
    if (session.getAttribute("id") != null) {
      System.out.println("아이디 : " + session.getAttribute("id"));
      resp.sendRedirect("/list");
      return;
    }

    req.setAttribute("loginFailed", false);
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/board/login.jsp");
    requestDispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {

    HttpSession session = req.getSession();

    // 로그인이 이미 되어있는 경우
    if (session.getAttribute("id") != null) {
      resp.sendRedirect("/list");
      return;
    }

    String id = req.getParameter("id");
    String passwd = req.getParameter("passwd");

    // 로그인 정보
    if (isLoginFail(id, passwd)) {
      req.setAttribute("loginFailed", true);
      req.getRequestDispatcher("/WEB-INF/jsp/board/login.jsp").forward(req, resp);
    } else {
      session.setAttribute("id", id);

      System.out.println(" 세션아이디 전  :" + session.getId());
      // 세션 고정 공격 방지 http://storyj.net/?p=52
      req.changeSessionId();
      System.out.println(" 세션아이디 후   :" + session.getId());
      resp.sendRedirect("/list");
    }
  }

  private boolean isLoginFail(String id, String passwd) {
    return !Objects.equal(userData.get(id), passwd);
  }
}
