package Project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/question2")
public class question2 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {

    String language = request.getParameter("favoriteLanguage");
    if ("Java".equals(language)) {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      out.println("<html><body>Java.</body></html>");
    } else {
      response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
    }
  }
}