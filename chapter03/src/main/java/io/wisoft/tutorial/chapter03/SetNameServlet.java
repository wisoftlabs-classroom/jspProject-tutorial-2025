package io.wisoft.tutorial.chapter03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/setName")
public class SetNameServlet extends HttpServlet {

  public SetNameServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // TODO: 현재 요청에 대한 세션을 생성하거나 기존 세션을 가져오세요. (1줄)

    // TODO: 세션에 "name"이라는 속성 이름으로 데이터를 저장하세요. (힌트: setAttribute 메서드 사용) (1줄)


    response.setContentType("text/html; charset=UTF-8");

    PrintWriter out = response.getWriter();
    out.println("<h1>이름저장<h1>");
  }
}
