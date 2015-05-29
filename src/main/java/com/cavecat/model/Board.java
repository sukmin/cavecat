package com.cavecat.model;


import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 게시글의 기본 정보를 저장한다.
 * 
 * @author serivires
 *
 */
@Alias("board")
public class Board {
  public static final String BOARDS = "boards";
  public static final String BOARD = "board";

  public static final String PARAM_TITLE = "title";
  public static final String PARAM_TEXT = "text";
  public static final String PARAM_ID = "id";

  private Long sequence;

  @NotBlank
  private String title;

  @NotBlank
  private String text;

  private Long readCount;

  private String shortUrl;

  private String registor;

  private String modifier;

  private Date registeredDate;

  private Date modifiedDate;

  private String delYn;

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

  public Long getReadCount() {
    return readCount;
  }

  public void setReadCount(Long readCount) {
    this.readCount = readCount;
  }

  public String getShortUrl() {
    return shortUrl;
  }

  public void setShortUrl(String shortUrl) {
    this.shortUrl = shortUrl;
  }

  public String getRegistor() {
    return registor;
  }

  public void setRegistor(String registor) {
    this.registor = registor;
  }

  public String getModifier() {
    return modifier;
  }

  public void setModifier(String modifier) {
    this.modifier = modifier;
  }

  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }

  public Date getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public String getDelYn() {
    return delYn;
  }

  public void setDelYn(String delYn) {
    this.delYn = delYn;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
