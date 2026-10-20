/*
 * Chapter 7: Generating the Server Response (HTTP Response Headers)
 * Summary: Uses the HTTP response header "Refresh" (response.setIntHeader) 
 * to instruct the browser to automatically reload the page at regular time intervals.
 */
package chapter7;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/chapter7/auto-refresh")
public class AutoRefresh extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setIntHeader("Refresh", 5); // Refresh every 5 seconds
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE HTML><HTML><BODY>");
        out.println("<H1>Auto-Refreshing Page</H1>");
        out.println("<P>Current Time: " + new Date() + "</P>");
        out.println("</BODY></HTML>");
    }
}