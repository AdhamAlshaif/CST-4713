package project5;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/question3page2")
public class question3page2 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    String bgColor = request.getParameter("bgColor");
    String fgColor = request.getParameter("fgColor");

    if (bgColor != null && fgColor != null) {
      Cookie bg = new Cookie("bgColor", bgColor);
      Cookie fg = new Cookie("fgColor", fgColor);
      bg.setMaxAge(60 * 60 * 24 * 365);
      fg.setMaxAge(60 * 60 * 24 * 365);
      response.addCookie(bg);
      response.addCookie(fg);

      response.sendRedirect("question3page1");
      return;
    }

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE HTML>");
    out.println("<HTML><BODY>");
    out.println("<H2>Choose Colors</H2>");
    out.println("<FORM ACTION=\"question3page2\">");
    out.println("Background Color: <INPUT TYPE=\"TEXT\" NAME=\"bgColor\"><BR>");
    out.println("Foreground Color: <INPUT TYPE=\"TEXT\" NAME=\"fgColor\"><BR><BR>");
    out.println("<INPUT TYPE=\"SUBMIT\" VALUE=\"Save Colors\">");
    out.println("</FORM>");
    out.println("</BODY></HTML>");
  }
}