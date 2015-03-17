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
import javax.xml.ws.Response;

public class LoginServlet extends HttpServlet {
	
private static final Map<String,String> userData = new HashMap<>();
	
	static {
		
		userData.put("serivires", "serivires");
		userData.put("killroad", "killroad");
		
	}	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// saveOnRestart로 서버가 리스타트되어도 세션이 연결된다. http://seemoon.tistory.com/121
		HttpSession session = req.getSession();
		
		// 로그인이 이미 되어있는 경우 
		if(session.getAttribute("id") != null){
			
			System.out.println("아이디 : " + session.getAttribute("id"));
			resp.sendRedirect("/board/board");
			return;
			
		}
		
		req.setAttribute("loginFailed",true);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/board/login.jsp");
		requestDispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		// 로그인이 이미 되어있는 경우 
		if(session.getAttribute("id") != null){
			
			resp.sendRedirect("/board/board");
			return;
			
		}
			
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		//로그인 정보
		if( isLoginFail(id, passwd) ){
			
			req.setAttribute("loginFailed",true);
			req.getRequestDispatcher("/WEB-INF/jsp/board/login.jsp").forward(req, resp);
			
		}else{
			
			session.setAttribute("id",id);
			// 세션 고정 공격 http://storyj.net/?p=52
			System.out.println(" 세션아이디 전  :" + session.getId());
			req.changeSessionId();
			System.out.println(" 세션아이디 후   :" +session.getId());
			resp.sendRedirect("/board/board");
			
		}
		
		
	
	}

	private boolean isLoginFail(String id, String passwd) {
		
		if(id == null || passwd == null){
			return true;
		}
		
		if( userData.containsKey(id) == false || passwd.equals(userData.get(id)) == false ){
			return true;
		}
		
		return false ;
	}
	

}
