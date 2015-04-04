package com.cavecat.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.AntPathMatcher;

public class LoginCheckFilter implements Filter {
  private FilterConfig config;
  private String loginPage;
  private String loginCertification;
  private String excludePattern;
  private AntPathMatcher pathMatcher = new AntPathMatcher();

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.config = filterConfig;
    this.loginPage = StringUtils.defaultString(config.getInitParameter("login-page"), "/login");
    this.loginCertification =
        StringUtils.defaultString(config.getInitParameter("login-Certification"), "/loginCertify");
    this.excludePattern = config.getInitParameter("exclude-pattern");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;

    if (StringUtils.isNotEmpty(excludePattern)) {
      if (pathMatcher.match(excludePattern, req.getRequestURI())) {
        chain.doFilter(request, response);
        return;
      }
    }

    if (pathMatcher.match(loginPage, req.getRequestURI())
        || pathMatcher.match(loginCertification, req.getRequestURI())) {
      chain.doFilter(request, response);
      return;
    }

    HttpSession session = req.getSession();
    if (session.getAttribute("id") != null) {
      chain.doFilter(request, response);
      return;
    }

    ((HttpServletResponse) response).sendRedirect(loginPage);
  }

  @Override
  public void destroy() {}
}
