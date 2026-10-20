/*
 * Chapter 2: First Servlets
 * Summary: Demonstrates setting the response content type to "text/html" 
 * and constructing a dynamic HTML page using PrintWriter.
 */
package chapter2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/chapter2/helloservlet")
public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<HTML><HEAD><TITLE>Hello Servlet</TITLE></HEAD>");
        out.println("<BODY><H1>Hello Servlet</H1></BODY></HTML>");
    }
}