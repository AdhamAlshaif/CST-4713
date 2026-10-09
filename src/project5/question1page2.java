package project5;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/page2")
public class question1page2 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    boolean visited = false;
    Cookie[] cookies = request.getCookies();

    // Check if the cookie exists
    if (cookies != null) {
      for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("visited")) {
          visited = true;
          break;
        }
      }
    }

    // Kick them out if they never visited page 1
    if (!visited) {
      response.sendRedirect("page1");
    } else {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      out.println("You have access to Page 2!");
    }
  }
}