package project5;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/question3page1")
public class question3page1 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    Cookie[] cookies = request.getCookies();
    String bgColor = getCookieValue(cookies, "bgColor", "white");
    String fgColor = getCookieValue(cookies, "fgColor", "black");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE HTML>");
    out.println("<HTML>");
    out.println("<BODY BGCOLOR=\"" + bgColor + "\" TEXT=\"" + fgColor + "\">");
    out.println("<H2>Informational Page</H2>");
    out.println("<P>This page displays information using your selected colors.</P>");
    out.println("<P><A HREF=\"question3page2\">Change Colors</A></P>");
    out.println("</BODY></HTML>");
  }

  private String getCookieValue(Cookie[] cookies, String cookieName, String defaultValue) {
    if (cookies != null) {
      for (int i = 0; i < cookies.length; i++) {
        Cookie cookie = cookies[i];
        if (cookieName.equals(cookie.getName())) {
          return cookie.getValue();
        }
      }
    }
    return defaultValue;
  }
}