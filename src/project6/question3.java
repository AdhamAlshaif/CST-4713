package project6;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/q3p6")
public class question3 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    
    List<String> referringPages = (List<String>)session.getAttribute("referringPages");
    if (referringPages == null) {
      referringPages = new ArrayList<String>();
      session.setAttribute("referringPages", referringPages);
    }

    String referer = request.getHeader("Referer");
    if (referer != null && !referringPages.contains(referer)) {
      referringPages.add(referer);
    }

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE HTML>");
    out.println("<HTML><BODY>");
    out.println("<H2>Referring Pages</H2>");
    
    if (referringPages.isEmpty()) {
      out.println("<P>No referring pages found.</P>");
    } else {
      out.println("<P>Pages that have linked to this servlet:</P>");
      out.println("<UL>");
      for (String page : referringPages) {
        out.println("<LI>" + page + "</LI>");
      }
      out.println("</UL>");
    }
    
    out.println("</BODY></HTML>");
  }
}