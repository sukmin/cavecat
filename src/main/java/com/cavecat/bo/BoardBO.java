package com.cavecat.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cavecat.dao.BoardDAO;
import com.cavecat.model.Board;

@Service
public class BoardBO {

  private BoardDAO boardDAO;

  @Autowired
  public BoardBO(BoardDAO boardDAO) {
    this.boardDAO = boardDAO;
  }

  @Transactional
  public Board getBoard(Long sequence) throws DataAccessException {
    boardDAO.updateCount(sequence);
    return boardDAO.selectOne(sequence);
  }

  @Transactional(readOnly = true)
  public List<Board> getBoardes() throws DataAccessException {
    return boardDAO.selectAll();
  }

  @Transactional
  public Long addBoard(Board board) throws DataAccessException {
    Long sequence = boardDAO.insert(board);
    return sequence;
  }

  @Transactional
  public boolean modifyBoard(Board board) throws DataAccessException {
    int changedLine = boardDAO.update(board);
    return changedLine > 0;
  }

  @Transactional
  public boolean removeBoard(Long sequence) throws DataAccessException {
    int changedLine = boardDAO.delete(sequence);
    return changedLine > 0;
  }

}
