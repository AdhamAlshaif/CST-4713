/*
 * Chapter 3: Handling the Client Request (Form Data)
 * Summary: Loops through all incoming parameters dynamically using request.getParameterNames() 
 * and handles multi-value inputs (like checkboxes) using request.getParameterValues().
 */
package chapter3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/chapter3/show-parameters")
public class ShowParameters extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML><HTML><BODY>");
        out.println("<H2 ALIGN=\"CENTER\">Parameter List</H2>");
        out.println("<TABLE BORDER=1 ALIGN=\"CENTER\">");
        out.println("<TR><TH>Parameter Name<TH>Parameter Value(s)");
        
        Enumeration paramNames = request.getParameterNames();
        while(paramNames.hasMoreElements()) {
            String paramName = (String)paramNames.nextElement();
            out.println("<TR><TD>" + paramName + "<TD>");
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                out.println(paramValues[0]);
            } else {
                out.println("<UL>");
                for(String val : paramValues) {
                    out.println("<LI>" + val);
                }
                out.println("</UL>");
            }
        }
        out.println("</TABLE></BODY></HTML>");
    }
}