package project6;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/q1p6")
public class question1 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    String heading;
    if (session.isNew()) {
      heading = "Welcome Aboard";
    } else {
      heading = "Welcome Back";
    }

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE HTML>");
    out.println("<HTML>");
    out.println("<BODY>");
    out.println("<H2>" + heading + "</H2>");
    out.println("</BODY></HTML>");
  }
}