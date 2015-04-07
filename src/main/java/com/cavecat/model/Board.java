package com.cavecat.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 게시글의 기본 정보를 저장한다.
 * 
 * @author serivires
 *
 */
public class Board {
  public static final String BOARDS = "boards";
  public static final String BOARD = "board";

  public static final String PARAM_TITLE = "title";
  public static final String PARAM_TEXT = "text";
  public static final String PARAM_ID = "id";

  private Long sequence = 0L;
  private String title;
  private String text;

  public Board() {}

  public Board(String title, String text) {
    this.title = title;
    this.text = text;
  }

  public Board(Long sequnece, String title, String text) {
    this.sequence = sequnece;
    this.title = title;
    this.text = text;
  }

  public Long getSequence() {
    return sequence;
  }

  public void setSequence(Long sequence) {
    this.sequence = sequence;
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
