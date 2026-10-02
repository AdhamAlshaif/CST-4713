package project45;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/question145")
public class question1 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (Math.random() < 0.5) {
      response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
      response.setHeader("Location", "http://www.google.com");
    } else {
      response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
      response.setHeader("Location", "http://www.bing.com");
    }
  }
}