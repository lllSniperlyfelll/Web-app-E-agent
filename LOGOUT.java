

package LOGOUT_USER;
/*edited*/
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.http.HttpSession;
import db_handler_package.DB_HANDLER;

public class LOGOUT extends HttpServlet
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			System.out.println("Logging out.......");
			HttpSession session=null;
			session=request.getSession();
			session.invalidate();
			//session=request.getSession(false);
			//System.out.println("session "+session.toString());
			response.sendRedirect("http://localhost:8080/Site_ud/");

		}
		catch(Exception e)
		{
			System.out.println("Exception from logout :"+e);
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}		
}
			
