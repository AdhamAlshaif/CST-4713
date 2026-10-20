/*
 * Chapter 5: Accessing the Standard CGI Variables
 * Summary: Extracts server environment and client connection details 
 * equivalent to legacy CGI variables (e.g., REMOTE_ADDR, REQUEST_METHOD, SERVER_PORT).
 */
package chapter5;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/chapter5/show-cgi")
public class ShowCGIVariables extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String[][] variables = {
            { "AUTH_TYPE", request.getAuthType() },
            { "CONTENT_LENGTH", String.valueOf(request.getContentLength()) },
            { "CONTENT_TYPE", request.getContentType() },
            { "QUERY_STRING", request.getQueryString() },
            { "REMOTE_ADDR", request.getRemoteAddr() },
            { "REMOTE_HOST", request.getRemoteHost() },
            { "REQUEST_METHOD", request.getMethod() },
            { "SERVER_NAME", request.getServerName() },
            { "SERVER_PORT", String.valueOf(request.getServerPort()) },
            { "SERVER_PROTOCOL", request.getProtocol() }
        };

        out.println("<!DOCTYPE HTML><HTML><BODY><TABLE BORDER=1>");
        for(int i=0; i<variables.length; i++) {
            out.println("<TR><TD><B>" + variables[i][0] + "</B><TD>" + variables[i][1]);
        }
        out.println("</TABLE></BODY></HTML>");
    }
}