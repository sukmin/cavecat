package com.cavecat.model;

public class User {

  public static final String USER = "user";
  public static final String PARAM_ID = "id";
  public static final String PARAM_PASSWD = "passwd";
  public static final String PARAM_LOGIN_FAILED = "loginFailed";

  private String id;
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
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((passwd == null) ? 0 : passwd.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (passwd == null) {
      if (other.passwd != null)
        return false;
    } else if (!passwd.equals(other.passwd))
      return false;
    return true;
  }

}
