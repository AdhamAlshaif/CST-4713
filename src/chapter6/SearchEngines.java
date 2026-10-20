/*
 * Chapter 6: Generating the Server Response (HTTP Status Codes)
 * Summary: Sends HTTP error status codes for bad requests (response.sendError) 
 * and performs server-side HTTP redirections (response.sendRedirect).
 */
package chapter6;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/chapter6/search-engines")
public class SearchEngines extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchString = request.getParameter("searchString");
        String engine = request.getParameter("engine"); 
        
        if (searchString == null || searchString.length() == 0) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing search string.");
            return;
        }
        
        String searchURL = null;
        if ("google".equals(engine)) {
            searchURL = "https://www.google.com/search?q=" + searchString;
        } else if ("bing".equals(engine)) {
            searchURL = "https://www.bing.com/search?q=" + searchString;
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Unrecognized search engine.");
            return;
        }
        
        response.sendRedirect(searchURL);
    }
}// ?searchString=java+servlets&engine=google add this to the end 