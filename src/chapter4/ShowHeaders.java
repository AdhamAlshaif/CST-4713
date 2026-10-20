/*
 * Chapter 4: Handling the Client Request (HTTP Request Headers)
 * Summary: Reads and displays all incoming HTTP headers sent by the client browser 
 * (such as User-Agent, Accept, and Host) using request.getHeaderNames().
 */
package chapter4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/chapter4/show-headers")
public class ShowHeaders extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML><HTML><BODY>");
        out.println("<H2 ALIGN=\"CENTER\">Request Headers</H2>");
        out.println("<TABLE BORDER=1 ALIGN=\"CENTER\">");
        out.println("<TR><TH>Header Name<TH>Header Value");
        
        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();
            out.println("<TR><TD>" + headerName + "<TD>" + request.getHeader(headerName));
        }
        out.println("</TABLE></BODY></HTML>");
    }
}