/*
 * Chapter 3: Handling the Client Request (Form Data)
 * Summary: Extracts specific named form parameters submitted from an HTML form 
 * using the request.getParameter() method.
 */
package chapter3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/chapter3/three-params1")
public class ThreeParams extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<HTML><BODY BGCOLOR=\"#FDF5E6\">");
        out.println("<H1 ALIGN=\"CENTER\">Reading Three Parameters</H1>");
        out.println("<UL>");
        out.println("  <LI>Param 1: " + request.getParameter("param1"));
        out.println("  <LI>Param 2: " + request.getParameter("param2"));
        out.println("  <LI>Param 3: " + request.getParameter("param3"));
        out.println("</UL>");
        out.println("</BODY></HTML>");
    }
}