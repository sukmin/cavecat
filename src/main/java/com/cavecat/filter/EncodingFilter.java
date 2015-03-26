package com.cavecat.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncodingFilter implements Filter {
  private static Logger logger = LoggerFactory.getLogger(EncodingFilter.class);
  private String encoding;

  @Override
  public void init(FilterConfig config) throws ServletException {
    this.encoding = StringUtils.defaultString(config.getInitParameter("encoding"), "UTF-8");
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
      throws IOException, ServletException {
    logger.debug("Request CharacterEncoding: {}", req.getCharacterEncoding());

    req.setCharacterEncoding(encoding);
    chain.doFilter(req, resp);
  }

  @Override
  public void destroy() {}
}
