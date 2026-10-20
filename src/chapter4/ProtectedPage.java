/*
 * Chapter 4: Handling Request Headers
 * Summary: Directly handles HTTP Basic Authentication by reading the "Authorization" 
 * header and issuing a 401 Unauthorized status with WWW-Authenticate if invalid.
 */
package chapter4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/chapter4/protected-page")
public class ProtectedPage extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setHeader("WWW-Authenticate", "BASIC realm=\"restricted-area\"");
            out.println("<H2>Authentication Required</H2>");
        } else {
            out.println("<H2>Welcome to the Protected Page!</H2>");
        }
    }
}