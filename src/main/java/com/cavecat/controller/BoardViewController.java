package com.cavecat.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.pegdown.PegDownProcessor;

import com.cavecat.model.Board;

public class BoardViewController implements Controller {

  @Override
  public String execute(Map<String, Object> model) throws Exception {
    @SuppressWarnings("unchecked")
    List<Board> boards = (List<Board>) model.get(Board.BOARDS);
    Long id = Long.parseLong((String) model.get(Board.PARAM_ID));

    // 임시 검색
    Board board = boards.stream().filter((e1) -> e1.getId().equals(id)) //
        .collect(Collectors.toList()).get(0);

    PegDownProcessor processor = new PegDownProcessor();
    board.setText(processor.markdownToHtml(board.getText()));

    model.put(Board.BOARD, board);

    return "/WEB-INF/jsp/board/view.jsp";
  }
}
