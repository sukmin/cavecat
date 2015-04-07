package com.cavecat.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cavecat.model.Board;

public class BoardDAO {


  private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Board> selectList() {

    return jdbcTemplate.query("SELECT * FROM board", new RowMapper<Board>() {

      @Override
      public Board mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Board board =
            new Board(resultSet.getLong("seq"), resultSet.getString("title"), resultSet
                .getString("content"));
        return board;
      }
    });

  }

  public Board selectOne(Long sequence) {
    return jdbcTemplate.queryForObject("SELECT * FROM board WHERE seq = ?",
        new Object[] {sequence}, new RowMapper<Board>() {

          @Override
          public Board mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Board board =
                new Board(resultSet.getLong("seq"), resultSet.getString("title"), resultSet
                    .getString("content"));
            return board;
          }
        });
  }

  public Long insertBoard(Board board) {

    jdbcTemplate.update("INSERT INTO board(title,content) VALUES(?,?)",
        new Object[] {board.getTitle(), board.getText()});
    board.setSequence(jdbcTemplate.queryForObject("SELECT last_insert_id()", Long.class));
    return board.getSequence();
  }
}
