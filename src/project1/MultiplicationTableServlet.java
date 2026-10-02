package project1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/multipletable")
public class MultiplicationTableServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>12 x 12 Multiplication Table</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>12 x 12 Multiplication Table</h1>");
        out.println("<table border='1' cellpadding='5' cellspacing='0'>");
        for (int row = 1; row <= 12; row++) {
            out.println("<tr>");
            for (int col = 1; col <= 12; col++) {
                out.println("<td>" + (row * col) + "</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
