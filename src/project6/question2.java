package project6;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/q2p6")
public class question2 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    HttpSession session = request.getSession();

    String firstName = request.getParameter("firstName");
    if ((firstName == null) || (firstName.length() == 0)) {
      firstName = (String)session.getAttribute("firstName");
      if (firstName == null) {
        firstName = "Unknown";
      }
    } else {
      session.setAttribute("firstName", firstName);
    }

    String lastName = request.getParameter("lastName");
    if ((lastName == null) || (lastName.length() == 0)) {
      lastName = (String)session.getAttribute("lastName");
      if (lastName == null) {
        lastName = "Unknown";
      }
    } else {
      session.setAttribute("lastName", lastName);
    }

    String emailAddress = request.getParameter("emailAddress");
    if ((emailAddress == null) || (emailAddress.length() == 0)) {
      emailAddress = (String)session.getAttribute("emailAddress");
      if (emailAddress == null) {
        emailAddress = "Unknown";
      }
    } else {
      session.setAttribute("emailAddress", emailAddress);
    }

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE HTML>");
    out.println("<HTML><BODY>");
    out.println("<H2>User Information (Sessions)</H2>");
    out.println("<FORM ACTION=\"" + request.getRequestURI() + "\">");
    out.println("First Name: <INPUT TYPE=\"TEXT\" NAME=\"firstName\" VALUE=\"" + firstName + "\"><BR>");
    out.println("Last Name: <INPUT TYPE=\"TEXT\" NAME=\"lastName\" VALUE=\"" + lastName + "\"><BR>");
    out.println("Email Address: <INPUT TYPE=\"TEXT\" NAME=\"emailAddress\" VALUE=\"" + emailAddress + "\"><BR><BR>");
    out.println("<INPUT TYPE=\"SUBMIT\" VALUE=\"Submit\">");
    out.println("</FORM>");
    out.println("</BODY></HTML>");
  }
}