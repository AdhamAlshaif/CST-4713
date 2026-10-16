package project6;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/q4p6")
public class question4 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    
    List<String> items = (List<String>)session.getAttribute("orderedItems");
    if (items == null) {
      items = new ArrayList<String>();
      session.setAttribute("orderedItems", items);
    }

    String newItem = request.getParameter("item");
    if (newItem != null && !newItem.trim().equals("")) {
      items.add(newItem);
    }

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE HTML>");
    out.println("<HTML><BODY>");
    out.println("<H2>Order Summary</H2>");
    
    if (!items.isEmpty()) {
      out.println("<UL>");
      Map<String, Integer> counts = new HashMap<String, Integer>();
      for (String item : items) {
        Integer count = counts.get(item);
        if (count == null) {
          counts.put(item, 1);
        } else {
          counts.put(item, count + 1);
        }
      }
      for (String item : counts.keySet()) {
        int count = counts.get(item);
        out.println("<LI>" + item + " (" + count + ")</LI>");
      }
      out.println("</UL>");
    }

    out.println("<FORM ACTION=\"" + request.getRequestURI() + "\">");
    out.println("Order Item: <INPUT TYPE=\"TEXT\" NAME=\"item\">");
    out.println("<INPUT TYPE=\"SUBMIT\" VALUE=\"Add Item\">");
    out.println("</FORM>");
    out.println("</BODY></HTML>");
  }
}