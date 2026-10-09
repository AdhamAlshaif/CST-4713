package project5;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/page1")
public class question1page1 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Cookie c = new Cookie("visited", "yes");
    c.setMaxAge(60 * 60 * 24 * 365);
    response.addCookie(c);

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<a href='page2'>Go to Page 2</a>");
  }
  
}