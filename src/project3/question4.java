package project3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloBrowser")
public class question4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String bgColor, fgColor;
        
        // Assume for simplicity that Edge and Firefox are the only two browsers
        String userAgent = request.getHeader("User-Agent");
        
        if ((userAgent != null) && (userAgent.contains("Edg"))) {
            bgColor = "RED";
            fgColor = "YELLOW";
        } else {
            bgColor = "YELLOW";
            fgColor = "RED";
        }
        
        String title = "Hello";
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
        
        out.println(docType +
                    "<HTML>\n" +
                    "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                    "<BODY BGCOLOR=\"" + bgColor + "\" TEXT=\"" + fgColor + "\">\n" +
                    "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
                    "</BODY></HTML>");
    }
}