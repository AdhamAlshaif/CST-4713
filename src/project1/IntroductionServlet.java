package project1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/intro")
public class IntroductionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String docType = 
            "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
            "Transitional//EN\">\n";
        out.println("<html>");
        out.println("<head><title>Personal Introduction</title></head>");
        out.println("<body>");
        out.println("<h1>Personal Introduction</h1>");
        out.println("<ul>");
        out.println("<li>Name: Adham Alshaif</li>");
        out.println("<li>Favorite Programming Language: Java</li>");
        out.println("<li>Favorite Hobby: Playing Video Games</li>");
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}