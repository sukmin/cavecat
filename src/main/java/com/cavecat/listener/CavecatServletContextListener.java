/*
 * @(#)CavecatServletContextListener.java $version 2015. 4. 7.
 * 
 * Copyright 2007 NHN Corp. All rights Reserved. NHN PROPRIETARY/CONFIDENTIAL. Use is subject to
 * license terms.
 */

package com.cavecat.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class CavecatServletContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext servletContext = sce.getServletContext();
    servletContext.setAttribute("jdbcTemplate", createJdbcTemplate());
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {}

  private JdbcTemplate createJdbcTemplate() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://serivires.iptime.co.kr/cavecat");
    dataSource.setUsername("");
    dataSource.setPassword("");
    dataSource.setInitialSize(3);
    dataSource.setMaxActive(10);

    return new JdbcTemplate(dataSource);
  }
}
