/*
 * Chapter 9: Session Tracking
 * Summary: Manages server-side state using HttpSession (request.getSession()), 
 * tracking unique session IDs, creation timestamps, and access visit counters.
 */
package chapter9;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/chapter9/show-session")
public class ShowSession extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        
        Integer accessCount = (Integer)session.getAttribute("accessCount");
        if (accessCount == null) {
            accessCount = 1;
        } else {
            accessCount++;
        }
        session.setAttribute("accessCount", accessCount);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML><HTML><BODY>");
        out.println("<H2>Session Information</H2>");
        out.println("<UL>");
        out.println("<LI>Session ID: " + session.getId());
        out.println("<LI>Creation Time: " + new Date(session.getCreationTime()));
        out.println("<LI>Access Count: " + accessCount);
        out.println("</UL></BODY></HTML>");
    }
}