package project3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//question 3 project 3

@WebServlet("/secondPage")
public class question3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Get the Referer header from the incoming request
        String referer = request.getHeader("referer");

        // 2. Check if referer is missing or does not contain "firstpage.html"
        if (referer == null || !referer.contains("firstpageq3p3.html")) {
            // Redirect the user back to firstpage.html
            response.sendRedirect("firstpageq3p3.html");
            return;
        }

        // 3. Display content if accessed through the link on firstpage.html
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Second Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome to the Second Page!</h1>");
        out.println("<p>You came from firstpage.html successfully.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}