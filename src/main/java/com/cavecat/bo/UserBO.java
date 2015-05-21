package com.cavecat.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavecat.dao.UserDAO;
import com.cavecat.model.User;

@Service
public class UserBO {

  @Autowired
  private UserDAO userDAO;

  public boolean isMember(User user) {
    return userDAO.selectCountForExist(user) == 1;
  }

  public boolean isNotMember(User user) {
    return !isMember(user);
  }


}
