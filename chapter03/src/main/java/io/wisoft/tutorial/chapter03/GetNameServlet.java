package io.wisoft.tutorial.chapter03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getName")
public class GetNameServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // TODO: 세션에서 "name" 속성을 가져오고, 문자열로 저장하세요. (2줄)

    response.setContentType("text/html; charset=UTF-8");

    PrintWriter out = response.getWriter();
//    out.println("<h1>name=" + name + "</h1>");
  }

}
