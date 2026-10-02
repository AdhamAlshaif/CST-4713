package project1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/randomcolor")
public class RandomColorServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String[] colors = {"Red", "Blue", "Green", "Yellow", "Orange",
                "Purple", "Black"};

        out.println("<html>");
        out.println("<head><title>Random Colors</title></head>");
        out.println("<body>");
        out.println("<h1>Five Random Colors</h1>");
        out.println("<ul>");
        for (int i = 0; i < 7; i++) {
            int randomIndex = (int) (Math.random() * colors.length);
            out.println("<li>" + colors[randomIndex] + "</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}