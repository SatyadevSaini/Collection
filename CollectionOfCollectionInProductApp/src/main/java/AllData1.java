

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


@WebServlet("/AllData1")
public class AllData1 extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
	PrintWriter out = null;
	try {
		out =resp.getWriter();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "Satya@123");
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery("select * from productapp");
		
		ArrayList al = new ArrayList();
		
		while(rs.next()) {
			
			HashMap all = new HashMap();
			all.put("product", rs.getString("product"));
			all.put("price", rs.getInt("price"));
			all.put("info", rs.getString("info"));
			
			al.add(all);	
		}
		req.setAttribute("coc", al);
		
		RequestDispatcher rd =  req.getRequestDispatcher("Help");
		rd.forward(req, resp);
				
	} catch (Exception e) {
		out.print(e);
	}

	
}
}
