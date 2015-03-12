package com.cavecat.board;

import java.io.IOException;

import javax.servlet.ServletException;
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
		
		String html = "<!doctype html><html lang=\"ko\"><head><meta charset=\"utf-8\"><title>%s</title></head><body>%s</body></html>";
		resp.getWriter().println(String.format(html, "무균실", "4층 무균실에는 뭔가 특별한 것이 있다."));
	}

}
