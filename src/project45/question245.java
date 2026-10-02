package project45;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/question245")
public class question245 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setIntHeader("Refresh", 5);
    response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    out.println("<html><body>" + new Date() + "</body></html>");
  }
}
