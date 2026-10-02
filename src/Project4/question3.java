package Project4;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/question3")
public class question3 extends HttpServlet {
    private int count = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        
        count++;
        
        if (count % 10 == 0) {
            response.sendRedirect("https://www.nytimes.com");
        } else {
            response.sendRedirect("https://www.washingtonpost.com");
        }
    }
}