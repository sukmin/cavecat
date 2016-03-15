/*
 * @(#)InterceptorConfig.java $version 2016. 3. 10.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cavecat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cavecat.interceptor.LoginCheckInterceptor;

/**
 * @author serivires
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

  @Autowired
  private LoginCheckInterceptor loginCheckInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(loginCheckInterceptor)
      .addPathPatterns("/**")
      .excludePathPatterns("/resources/**")
      .excludePathPatterns("/login")
      .excludePathPatterns("/signup");

    super.addInterceptors(registry);
  }

  @Bean(name="loginCheckInterceptor")
  public LoginCheckInterceptor loginCheckInterceptor() {
    LoginCheckInterceptor interceptor = new LoginCheckInterceptor();
    interceptor.setRedirectPath("/login");
    return interceptor;
  }
}
