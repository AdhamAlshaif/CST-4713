/*
 * Chapter 8: Handling Cookies (ReadCookies)
 * Summary: Retrieves all cookies sent with the client request using request.getCookies() 
 * and loops through them to display their names and values.
 */
package chapter8;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/chapter8/read-cookies")
public class ReadCookies extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML><HTML><BODY><H2>Active Cookies:</H2><UL>");
        
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<LI>" + c.getName() + " = " + c.getValue());
            }
        } else {
            out.println("<LI>No cookies found.");
        }
        out.println("</UL></BODY></HTML>");
    }
}