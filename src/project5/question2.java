package project5;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/proj5q2")
public class question2 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    Cookie[] cookies = request.getCookies();

    String firstName = request.getParameter("firstName");
    if ((firstName == null) || (firstName.length() == 0)) {
      firstName = getCookieValue(cookies, "firstName", "Unknown");
    } else {
      Cookie c = new Cookie("firstName", firstName);
      c.setMaxAge(60 * 60 * 24 * 365);
      response.addCookie(c);
    }

    String lastName = request.getParameter("lastName");
    if ((lastName == null) || (lastName.length() == 0)) {
      lastName = getCookieValue(cookies, "lastName", "Unknown");
    } else {
      Cookie c = new Cookie("lastName", lastName);
      c.setMaxAge(60 * 60 * 24 * 365);
      response.addCookie(c);
    }

    String emailAddress = request.getParameter("emailAddress");
    if ((emailAddress == null) || (emailAddress.length() == 0)) {
      emailAddress = getCookieValue(cookies, "emailAddress", "Unknown");
    } else {
      Cookie c = new Cookie("emailAddress", emailAddress);
      c.setMaxAge(60 * 60 * 24 * 365);
      response.addCookie(c);
    }

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE HTML>");
    out.println("<HTML><BODY>");
    out.println("<H2>User Information</H2>");
    out.println("<FORM ACTION=\"proj5q2\">");
    out.println("First Name: <INPUT TYPE=\"TEXT\" NAME=\"firstName\" VALUE=\"" + firstName + "\"><BR>");
    out.println("Last Name: <INPUT TYPE=\"TEXT\" NAME=\"lastName\" VALUE=\"" + lastName + "\"><BR>");
    out.println("Email Address: <INPUT TYPE=\"TEXT\" NAME=\"emailAddress\" VALUE=\"" + emailAddress + "\"><BR><BR>");
    out.println("<INPUT TYPE=\"SUBMIT\" VALUE=\"Submit\">");
    out.println("</FORM>");
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