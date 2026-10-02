package project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/three-params")
public class ThreeParams extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Reading Three Request Parameters";

    String param1 = request.getParameter("param1");
    String param2 = request.getParameter("param2");
    String param3 = request.getParameter("param3");

    if (param1 == null || param1.trim().isEmpty()) {
      param1 = "Missing First Name";
    }
    if (param2 == null || param2.trim().isEmpty()) {
      param2 = "Missing Last Name";
    }
    if (param3 == null || param3.trim().isEmpty()) {
      param3 = "Missing Email Address";
    }

    param1 = ServletUtilities.filter(param1);
    param2 = ServletUtilities.filter(param2);
    param3 = ServletUtilities.filter(param3);

    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<UL>\n" +
                "  <LI><B>First Name</B>: " + param1 + "\n" +
                "  <LI><B>Last Name</B>: " + param2 + "\n" +
                "  <LI><B>Email Address</B>: " + param3 + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}