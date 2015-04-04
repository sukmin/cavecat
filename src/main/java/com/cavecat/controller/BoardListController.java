package com.cavecat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cavecat.model.Board;

public class BoardListController implements Controller {

  private static Logger logger = LoggerFactory.getLogger(BoardListController.class);

  @Override
  public String execute(Map<String, Object> model) throws Exception {

    @SuppressWarnings("unchecked")
    List<Board> boards = (List<Board>) model.get(Board.BOARDS);
    if (Objects.isNull(boards)) {
      boards = new ArrayList<>();
    } else {
      boards = sortBoardList(boards);
    }

    logger.info("현재 보드 갯수 : {}", boards.size());

    return "/WEB-INF/jsp/board/list.jsp";
  }

  private List<Board> sortBoardList(List<Board> boards) {

    boards =
        boards.stream().sorted((e1, e2) -> Long.compare(e2.getId(), e1.getId()))
            .collect(Collectors.toList());
    return boards;
  }


}
