package com.cavecat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="cc_user")
public class User {
  public static final String USER = "user";
  public static final String PARAM_ID = "id";
  public static final String PARAM_PASSWD = "passwd";
  public static final String PARAM_LOGIN_FAILED = "loginFailed";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "seq", unique = true, nullable = false)
  private Long sequence;
  
  @Column(name = "cc_id", length = 30, nullable = false)
  private String id;

  @Column(name = "cc_passwd", length = 500, nullable = false)
  private String passwd;

  @Column(name = "cc_email", length = 500, nullable = false)
  private String email;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "reg_ymdt", nullable = false)
  private Date registeredDate;

  @Column(name = "email_validate", length = 1, nullable = true)
  private String emailValidate = "N";

  @Column(name = "del_yn",  length = 1, nullable = true)
  private String delYn = "N";
  
  public User() {};

  public User(String id, String passwd) {
    this.id = id;
    this.passwd = passwd;
  }

  public User(String id) {
    this(id, null);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getRegisteredDate() {
	return registeredDate;
}

public void setRegisteredDate(Date registeredDate) {
	this.registeredDate = registeredDate;
}

@Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }
}
