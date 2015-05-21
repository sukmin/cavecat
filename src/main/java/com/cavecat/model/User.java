package com.cavecat.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;

@Alias("user")
public class User {
  public static final String USER = "user";
  public static final String PARAM_ID = "id";
  public static final String PARAM_PASSWD = "passwd";
  public static final String PARAM_LOGIN_FAILED = "loginFailed";

  @NotEmpty
  private String id;

  @NotEmpty
  private String passwd;

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

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }
}
