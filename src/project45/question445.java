package project45;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/question445")
public class question445 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String userAgent = request.getHeader("User-Agent");

    if (userAgent != null && userAgent.contains("MSIE")) {
      response.setHeader("Refresh", "10; URL=http://www.microsoft.com");
      out.println("<html><body>You will be sent to http://www.microsoft.com after 10 seconds.</body></html>");
    } else {
      response.setHeader("Refresh", "10; URL=http://www.mozilla.org");
      out.println("<html><body>You will be sent to http://www.mozilla.org after 10 seconds.</body></html>");
    }
  }
}