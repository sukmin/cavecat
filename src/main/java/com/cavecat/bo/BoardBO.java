package com.cavecat.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import com.cavecat.dao.BoardDAO;
import com.cavecat.model.Board;

@Service
public class BoardBO {

  @Autowired
  private BoardDAO boardDAO;

  @Transactional
  public Board getBoard(Long sequence) throws DataAccessException {
    Board board = boardDAO.findOne(sequence);

    board.setReadCount(board.getReadCount() + 1);
    board.setTitle(HtmlUtils.htmlEscape(board.getTitle(), "utf-8"));

    boardDAO.save(board);
    board.setText(HtmlUtils.htmlEscape(board.getText()));

    return board;
  }

  @Transactional(readOnly = true)
  public List<Board> getBoardes() throws DataAccessException {
    return boardDAO.findAll(new Sort(Sort.Direction.DESC, "sequence"));
  }

  @Transactional
  public Long addBoard(Board board) throws DataAccessException {
    board.setRegisteredDate(new Date());
    board = boardDAO.save(board);
    return board.getSequence();
  }

  @Transactional
  public void modifyBoard(Board board) throws DataAccessException {
    boardDAO.save(board);
  }

  @Transactional
  public void removeBoard(Long sequence) throws DataAccessException {
    boardDAO.delete(sequence);
  }
}
