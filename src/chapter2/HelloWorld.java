/*
 * Chapter 2: First Servlets
 * Summary: Simplest possible servlet that extends HttpServlet, overrides doGet(), 
 * and outputs plain text directly to the response output stream.
 */
package chapter2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/chapter2/hello")
public class HelloWorld extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello World</h1>");
    }
}