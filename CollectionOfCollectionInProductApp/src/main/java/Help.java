

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Help")
public class Help extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		PrintWriter out = null;
		try {
			out = response.getWriter();
			
			ArrayList alldata = (ArrayList)request.getAttribute("coc");  // collection of Collection Stored in the alldata..
			
			for(Object o : alldata) {
				HashMap data = (HashMap)o ;
				
				out.print("<html><body>");
				out.print("<p>Product "+data.get("product")+" </p>");
				out.print("<p>Price "+data.get("price")+" </p>");
				out.print("<p>Info "+data.get("info")+" </p> <hr>");
				out.print("</body> </html>");
			
			}
		} catch (Exception e) {
			out.print(e);
		}
		
	}

}
