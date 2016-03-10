/*
 * @(#)BoardDAO.java $version 2016. 3. 9.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.cavecat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cavecat.model.Board;

/**
 * @author serivires
 */
public interface BoardDAO extends JpaRepository<Board, Long> {
}
