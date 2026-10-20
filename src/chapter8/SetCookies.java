/*
 * Chapter 8: Handling Cookies (SetCookies)
 * Summary: Creates a new Cookie object, sets an expiration age, 
 * and attaches it to the HTTP response using response.addCookie().
 */
package chapter8;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/chapter8/set-cookies")
public class SetCookies extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie userCookie = new Cookie("userID", "User12345");
        userCookie.setMaxAge(60 * 60 * 24); // Valid for 1 day
        response.addCookie(userCookie);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML><HTML><BODY><H2>Cookie Set Successfully!</H2></BODY></HTML>"+userCookie);
    }
}