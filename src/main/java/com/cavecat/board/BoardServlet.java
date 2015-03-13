package com.cavecat.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 4251285399811752982L;

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

		// 모든 서블릿에서 공유하는 값
		ServletContext servletContext = this.getServletContext();
		System.out.println(servletContext.getInitParameter("movie"));
		System.out.println(servletContext.getInitParameter("game"));

		// 해당 서블릿에서만 사용할 수 있는 값
		ServletConfig servletConfig = this.getServletConfig();
		System.out.println(servletConfig.getInitParameter("bookStore"));
		System.out.println(servletConfig.getInitParameter("gameSite"));

		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/board/file.jsp");
		requestDispatcher.forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(req.getParameter("testText"));
		System.out.println(req.getPart("testFile").getName());
		
	}

}
