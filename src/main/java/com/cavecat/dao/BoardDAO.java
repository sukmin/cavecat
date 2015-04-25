package com.cavecat.dao;

import java.util.List;

import com.cavecat.model.Board;

public interface BoardDAO {

  public List<Board> selectAll();

  public Board select(Long sequence);

  public Long insert(Board board);

  public Board update(Board board);

  public void delete(Board board);

}
