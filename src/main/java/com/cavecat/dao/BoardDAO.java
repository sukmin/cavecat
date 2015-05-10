package com.cavecat.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cavecat.model.Board;

/**
 * 참고 : http://netframework.tistory.com/353 <br>
 * 참고 : https://www.yammacode.com/view?id=122
 * 
 * @author sukmin
 *
 */
@Repository
public class BoardDAO {

  private static final String NAMESPACE = BoardDAO.class.getPackage().getName() + ".BoardDAO.";

  @Autowired
  private SqlSessionTemplate sqlSessionTemplate;

  public List<Board> selectAll() {
    return sqlSessionTemplate.selectList(NAMESPACE + "selectAll");
  }

  public Board selectOne(Long sequence) {
    return sqlSessionTemplate.selectOne(NAMESPACE + "selectOne", sequence);
  }

  public Long insert(Board board) {
    sqlSessionTemplate.insert(NAMESPACE + "insert", board);
    return board.getSequence();
  }

  public int update(Board board) {
    return sqlSessionTemplate.update(NAMESPACE + "update", board);
  }

  public void updateCount(Long sequence) {
    sqlSessionTemplate.update(NAMESPACE + "updateCount", sequence);
  }

  public int delete(Long sequence) {
    return sqlSessionTemplate.delete(NAMESPACE + "delete", sequence);
  }
}
