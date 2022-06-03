

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

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			//get data from client it is like Query ....
			String s1 = request.getParameter("product");
			
		//jdbc Connection 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "Satya@123");
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("select * from productapp where product like '%"+s1+"%' ");
			
			//Collection 
			
			ArrayList AllUsers = new ArrayList();
			
			while(rs.next()) {
				
				//collection HashMap
				HashMap users = new HashMap();  
				
				users.put("product", rs.getString("product"));
				users.put("price", rs.getInt("price"));
				users.put("info", rs.getString("info"));
		    
				AllUsers.add(users);  // it is collection Of Collection here ... 
			}
			
			// set attribute 
			request.setAttribute("au", AllUsers);
			
			RequestDispatcher rd = request.getRequestDispatcher("Helper");
			rd.forward(request, response);
			
		} catch (Exception e) {
			out.print(e);
		}
	}

}
