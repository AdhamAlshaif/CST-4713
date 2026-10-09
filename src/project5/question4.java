package project5;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/question4")
public class question4 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    Cookie[] cookies = request.getCookies();
    String sessionVal = getCookieValue(cookies, "sessionCookie", "Not Set Yet");
    String persistentVal = getCookieValue(cookies, "persistentCookie", "Not Set Yet");

    if (sessionVal.equals("Not Set Yet")) {
      Cookie sessionCookie = new Cookie("sessionCookie", "ActiveSessionValue");
      response.addCookie(sessionCookie);

      Cookie persistentCookie = new Cookie("persistentCookie", "LongLivedValue");
      persistentCookie.setMaxAge(60 * 60 * 24 * 365);
      response.addCookie(persistentCookie);

      sessionVal = "ActiveSessionValue";
      persistentVal = "LongLivedValue";
    }

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE HTML>");
    out.println("<HTML>");
    out.println("<BODY>");
    out.println("<H2>Cookie Lifespan Test</H2>");
    out.println("<P>Session Cookie: " + sessionVal + "</P>");
    out.println("<P>Persistent Cookie: " + persistentVal + "</P>");
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