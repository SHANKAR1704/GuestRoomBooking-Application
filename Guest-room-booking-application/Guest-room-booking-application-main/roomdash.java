package pac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class roomdash
 */
@WebServlet("/roomdash")
public class roomdash extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public roomdash() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				try
				{
					 Class.forName("com.mysql.jdbc.Driver");  
					 Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3309/booking","root", "");
					 Statement stmt=con.createStatement();  
					 ResultSet rs=stmt.executeQuery("select * from addrooms");  
					 out.println("<html>");
					 out.println("<head>");
					 out.println("<style>");
					 out.println(".border1{");
                     out.println("height: 45px;");
                     out.println("width: 90.9%;");
                     out.println("background-color: black;");
                     out.println("padding: 20px 20px 10px 120px;");
                     out.println("position: absolute;}");
                     out.println("border2{");
                     out.println("height: 45px;");
                     out.println("width: 90.9%;");
                     out.println("background-color:#2CC185");
                     out.println("padding: 20px 20px 10px 120px;");
                     out.println("position: absolute;}");
                     out.println("header{");
                     out.println("font-family: 'Satisfy', cursive;");
                     out.println("font-size: 35px;");
                     out.println("letter-spacing: 2px;");
                     out.println("color: white;}");
                     out.println("table,th,td{");
                     out.println("border:1px solid black;}");
                     out.println("table {");
                     out.println("border-collapse: collapse;}");
                     out.println("td {");
                     out.println("padding: 10px;}");
                     out.println("</style>");
                     out.println("</head>");
                     out.println("<body>");
                     out.println("<div class=border1><header><b>BookingRooms.com");
                     out.println("<br><br><br>");
                     out.println("<table border:1>");
                     out.println("<tr><td>");
                     out.println("<b><h2>ROOM NO");
                     out.println("</td>");
                     out.println("<td><h2><b>FLOOR SIZE</td>");
                     out.println("<td><h2><b>NO OF BEDS</td>");
                     out.println("<td><h2><b>AC(OR)NON-AC</td>");
                     out.println("<td><h2><b>Rent(per day)</td>");
                     out.println("<td><h2><b>Minimum stay(days)</td>");
                     out.println("<td><h2><b>Maximum stay(days)</td>");
                     out.println("<td><h2><b>Other facilities</td>");
                     out.println("<td><h2><b>Book now</td>");
                     out.println("</tr>");
                     while(rs.next())
                     {
                    	 out.println("<form action=booking.html>");
                    	 out.println("<tr>");
                    	 out.println("<td>");
                    	 out.println(rs.getString(1));
                    	 out.println("</td>");
                    	 out.println("<td>");
                    	 out.println(rs.getString(2));
                    	 out.println("</td>");
                    	 out.println("<td>");
                    	 out.println(rs.getString(3));
                    	 out.println("</td>");
                    	 out.println("<td>");
                    	 out.println(rs.getString(4));
                    	 out.println("</td>");
                    	 out.println("<td>");
                    	 out.println(rs.getString(5));
                    	 out.println("</td>");
                    	 out.println("<td>");
                    	 out.println(rs.getString(6));
                    	 out.println("</td>");
                    	 out.println("<td>");
                    	 out.println(rs.getString(7));
                    	 out.println("</td>");
                    	 out.println("<td>");
                    	 out.println(rs.getString(8));
                    	 out.println("</td>");
                    	 out.println("<td><button  style=background-color:#2CC185 ;color:white;text-align:center;border-color:#2CC185;height:40px;width:80px>Click to Book</button>");
                    	 out.println("</td>");
                    	 out.println("</tr>");

                     }
				}
				catch(Exception e)
				{
					System.out.println(e);
					}  
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
