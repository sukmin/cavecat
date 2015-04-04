package com.cavecat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cavecat.DispatcherServlet;
import com.cavecat.model.Board;

public class BoardListController implements Controller {

  private static Logger logger = LoggerFactory.getLogger(BoardListController.class);

  @Override
  public String execute(Map<String, Object> model) throws Exception {
    ServletContext servletContext = (ServletContext) model.get(DispatcherServlet.SERVLET_CONTEXT);
    @SuppressWarnings("unchecked")
    List<Board> boards = (List<Board>) model.get(Board.BOARDS);
    if (Objects.isNull(boards)) {
      boards = new ArrayList<>();
      boards.add(getDummyBoard());
      servletContext.setAttribute(Board.BOARDS, boards);
    } else {
      boards = sortBoardList(boards);
    }

    logger.info("현재 보드 갯수 : {}", boards.size());

    model.put(Board.BOARDS, boards);
    return "/WEB-INF/jsp/board/list.jsp";
  }

  private List<Board> sortBoardList(List<Board> boards) {
    return boards.stream(). //
        sorted((e1, e2) -> Long.compare(e2.getId(), e1.getId())) //
        .collect(Collectors.toList());
  }

  private Board getDummyBoard() {
    Board board = new Board();
    board.setId(1L);
    board.setTitle("고양이");
    board
        .setText("#고양이\r\n  고양이는 포유류동물에 속하는 동물이다. 일반적으로 \"고양이\"라 "
            + " 함은 인간에게 길들여진 집고양이를 말한다."
            + " [야생고양이](http://ko.wikipedia.org/wiki/%EB%93%A4%EA%B3%A0%EC%96%91%EC%9D%B4)는 약 10만 년에서 7만 년 전부터 존재했다."
            + " 2007년 기준으로 최근의 연구에 따르면 길들여진 고양이의 기원은 약 1만 년 전 근동지방에서"
            + " 스스로 숲 속을 나와 사람들이 모여사는 마을에 대담하게 정착하여 길들여진 "
            + "5마리 정도의 아프리카들고양이(Felis silvestris lybica)로 추측된다.\r\n\r\n"
            + "1. 발\r\n\r\n  ![발](http://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/Cat_paw_%28cloudzilla%29.jpg/200px-Cat_paw_%28cloudzilla%29.jpg)\r\n\r\n"
            + "개와 마찬가지로 고양이는 발가락으로 걷는 지행동물이다. 고양이는 발의 뼈가 다리의 아래 부분이 되며, 직접 발가락으로 걷는다. "
            + "고양이는 뒷발을 거의 정확하게 상응하는 앞발의 발자국에 놓음으로써 소음과 흔적을 최소화 한다. "
            + "이것은 또한 고양이들이 거친 지역을 돌아 다닐 때 뒷발에 확실한 발판을 제공하는 역할을 한다. "
            + "고양이과 동물들의 특성으로, 오므릴 수 있는 발톱을 가지고 있다. "
            + "보통의 긴장이 풀린 상태에서 발톱은 발바닥 근처의 피부와 털로 덮여 있어 발톱이 지면과의 접촉으로 인하여 닳는 것을 방지하여 "
            + "발톱을 날카롭게 유지하며 또한 사냥감을 조용히 따라갈 수 있게 한다. 앞발의 발톱은 일반적으로 뒷발톱 보다 날카롭다. "
            + "고양이는 의도적으로 하나 이상의 발의 발톱을 꺼낼 수 있다. 고양이는 사냥이나 자기방어, 타고 오르기, 주무르기 "
            + "혹은 침구류나 두꺼운 러그 등의 부드러운 표면에 추가 마찰을 위하여 발톱을 꺼낼 수 있다. 온순한 고양이의 발 위 아래를 "
            + "조심스럽게 누름으로써 발톱을 꺼낼 수도 있다. 굽어 있는 고양이의 발톱은 카펫나 다른 두꺼운 천 등에 걸리기도 하며, "
            + "스스로 빼낼 수 없을 경우 고양이를 다치게 할 수도 있다. 일반적으로 앞발에 다섯 개, 뒷발에 네 개나 다섯 개의 발톱을 가지고 있으나 "
            + "오랜 돌연변이의 결과로 집고양이들은 다지증에 걸리기 쉬우며 여섯 개나 일곱 개의 발가락을 가지고 있을 수도 있다. "
            + "다섯 번째의 앞발톱은 다른 발톱에 인접하여 있으며, 좀 더 인접하여 여섯 번째의 손가락인 돌출부가 있다. "
            + "발목 안쪽에 위치한 앞발의 이러한 특수한 모양은 손목관절의 패드로 큰 고양이들이나 개들의 발에서도 발견된다. "
            + "이것은 보통 걸음걸이에는 기능하지 않으나 도약할 때 미끄러지지 않도록 해주는 기능을 한다고 믿어지고 있다.");

    return board;
  }
}
