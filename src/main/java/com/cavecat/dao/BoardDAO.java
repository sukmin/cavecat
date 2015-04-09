package com.cavecat.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cavecat.model.Board;

public class BoardDAO {
  private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Board> selectList() {
    return jdbcTemplate.query("SELECT * FROM board ORDER By seq DESC", this::mapBoard);
  }

  public Board selectOne(Long sequence) {
    return jdbcTemplate.queryForObject("SELECT * FROM board WHERE seq = ?",
        new Object[] {sequence}, this::mapBoard);
  }

  private Board mapBoard(ResultSet rs, int rowNum) throws SQLException {
    Board board = new Board();
    board.setSequence(rs.getLong("seq"));
    board.setTitle(rs.getString("title"));
    board.setText(rs.getString("content"));
    return board;
  }

  public Board insertOne(Board board) {
    jdbcTemplate.update("INSERT INTO board(title,content) VALUES(?,?)",
        new Object[] {board.getTitle(), board.getText()});

    board.setSequence(jdbcTemplate.queryForObject("SELECT last_insert_id()", Long.class));
    return board;
  }
}
