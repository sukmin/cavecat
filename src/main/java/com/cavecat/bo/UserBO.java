package com.cavecat.bo;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavecat.dao.UserDAO;
import com.cavecat.model.User;

@Service
public class UserBO {

  @Autowired
  private UserDAO userDAO;

  @PostConstruct
  public void init() {
    User user1 = new User();
    user1.setId("test");
    user1.setPasswd("123");
    user1.setEmail("test@test.com");
    user1.setRegisteredDate(new Date());
    userDAO.save(user1);
  }

  public boolean isMember(User user) {
    return (userDAO.findByIdAndPasswd(user.getId(), user.getPasswd()) != null);
  }

  public boolean isNotMember(User user) {
    return !isMember(user);
  }

}
