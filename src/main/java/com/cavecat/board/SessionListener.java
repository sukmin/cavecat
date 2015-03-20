package com.cavecat.board;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener, HttpSessionIdListener {
  private SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");

  // 세션아이디가 변경될 때 호출
  @Override
  public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
    System.out.println(this.date() + ": Session ID " + oldSessionId + " changed to "
        + event.getSession().getId());
  }

  // 세션아이디가 생성될 때 호출
  @Override
  public void sessionCreated(HttpSessionEvent event) {
    System.out.println(this.date() + ": Session " + event.getSession().getId() + " created.");
  }

  // 세션아이디가 만료되거나 명시적으로 Session.invalidate()가 호출될때 호출
  @Override
  public void sessionDestroyed(HttpSessionEvent event) {
    System.out.println(this.date() + ": Session " + event.getSession().getId() + " destroyed.");
  }

  private String date() {
    return this.formatter.format(new Date());
  }
}
