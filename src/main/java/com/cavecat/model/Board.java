package com.cavecat.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 게시글의 기본 정보를 저장한다.
 * 
 * @author serivires
 *
 */
@Entity
@Table(name = "board")
public class Board {
  public static final String BOARDS = "boards";
  public static final String BOARD = "board";

  public static final String PARAM_TITLE = "title";
  public static final String PARAM_TEXT = "text";
  public static final String PARAM_ID = "id";

  @Id
  @GeneratedValue
  @Column(name = "seq", unique = true)
  private Long sequence = 0L;

  @NotBlank
  @Column(name = "title", length = 1000)
  private String title;

  @NotBlank
  @Column(name = "content")
  private String text;

  @Column(name = "read_count")
  private Long readCount;

  @Column(name = "reg_id", updatable = false)
  private String registor;

  @Column(name = "mod_id")
  private String modifier;

  @Temporal(TemporalType.TIMESTAMP)
  @org.hibernate.annotations.Generated(value = GenerationTime.ALWAYS)
  @Column(name = "reg_ymdt", updatable = false)
  private Date registeredDate;

  @Temporal(TemporalType.TIMESTAMP)
  @org.hibernate.annotations.Generated(value = GenerationTime.ALWAYS)
  @Column(name = "mod_ymdt")
  private Date modifiedDate;

  @Column(name = "del_yn", nullable = false)
  private String delYn = "n";

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
