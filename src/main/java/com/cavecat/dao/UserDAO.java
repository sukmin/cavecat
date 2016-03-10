/*
 * @(#)UserDAO.java $version 2016. 3. 9.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cavecat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cavecat.model.User;

/**
 * @author NTS YongJu Choi
 */
public interface UserDAO extends JpaRepository<User, Long> {
  public List<User> findByIdAndPasswd(String id, String passwd);
}
