

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Helper")
public class Helper extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			// get Attribute in which we have Colllection of Collection 
			String s1 = request.getParameter("product");
			
			ArrayList AllUsers = (ArrayList)request.getAttribute("au");  // here we get the Attribute ...
			
			out.print("<html><body>");
			
			if(AllUsers.isEmpty()) {
			out.print("<p> It is Empty  No Data Found Here </p>");
		}
			
			for(Object o: AllUsers ) {
				
				HashMap users = (HashMap)o;
				
				out.print("<p>Product : "+users.get("product")+"</p>");
				out.print("<p>Price : "+users.get("price")+"</p>");
				out.print("<p>Info : "+users.get("info")+"</p>");
				out.print("<hr> ");
			}
			out.print("</body></html>");
			
		}catch (Exception e) {
			out.print(e);
		}
	}
}
