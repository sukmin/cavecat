package com.cavecat.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cavecat.model.User;

@Repository
public class UserDAO {

  private static final String NAMESPACE = UserDAO.class.getPackage().getName() + ".UserDAO.";

  @Autowired
  private SqlSessionTemplate sqlSessionTemplate;

  public int selectCountForExist(User user) {
    return sqlSessionTemplate.selectOne(NAMESPACE + "selectCountForExist", user);
  }
}
