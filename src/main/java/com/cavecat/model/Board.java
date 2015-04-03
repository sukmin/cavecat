package com.cavecat.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 게시글의 기본 정보를 저장한다.
 * 
 * @author serivires
 *
 */
public class Board {
  private Long id = 0L;
  private String title;
  private String text;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
