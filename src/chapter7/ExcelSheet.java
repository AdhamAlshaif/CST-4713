/*
 * Chapter 7: Generating Server Response (HTTP Response Headers)
 * Summary: Overrides the default HTML content type to output data directly into 
 * Microsoft Excel using the "application/vnd.ms-excel" content type.
 */
package chapter7;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/chapter7/excel-data")
public class ExcelSheet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/vnd.ms-excel");
        PrintWriter out = response.getWriter();
        out.println("Item\tQuantity\tPrice");
        out.println("Java Book\t1\t45.99");
        out.println("Servlet Guide\t2\t29.99");
    }
}