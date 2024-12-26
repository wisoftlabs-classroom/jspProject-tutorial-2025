package io.wisoft.tutorial.chapter03;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DispatcherServlet extends HttpServlet {

  public DispatcherServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // TODO: 요청 속성 "request"에 값을 설정하세요. (예: "requestValue") (1줄)

    // TODO: 요청을 "dispatcher.jsp"로 전달할 RequestDispatcher 객체를 생성하세요. (1줄)

    // TODO: RequestDispatcher의 forward 메서드를 사용해 현재 요청과 응답을 "dispatcher.jsp"에 전달하세요.(1줄)


  }

}
