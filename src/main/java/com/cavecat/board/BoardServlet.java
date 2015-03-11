package com.cavecat.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardServlet extends HttpServlet {

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped.");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started.");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println("국내 스프링 다섯손가락 안에 들어가는 고수가 8층에 있다.");
	}

}
