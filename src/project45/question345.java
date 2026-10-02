package project45;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/question345")
public class question345 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("application/vnd.ms-excel");
    PrintWriter out = response.getWriter();

    for (int row = 0; row < 10; row++) {
      for (int col = 0; col < 5; col++) {
        out.print((int)(Math.random() * 100) + "\t");
      }
      out.println();
    }
  }
}