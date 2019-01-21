package session_handler;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.http.HttpSession;
import db_handler_package.DB_HANDLER;

public class SESSION_CREATOR extends HttpServlet
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				HttpSession session=null;
				try
				{		
				int Username_Status=0;
				int Password_Status=0;
				String uemail=request.getParameter("username");
				String upassword=request.getParameter("userpassword");
				System.out.println(uemail);
				System.out.println(upassword);
				Connection conn=null;
				DB_HANDLER DBH=new DB_HANDLER();
				conn=DBH.DB_CONNECTOR();
				Statement stmt =conn.createStatement();
				ResultSet rss=stmt.executeQuery("SELECT  password  FROM user_login where email='"+uemail+"'");
				while(rss.next())
				{
					String pass=rss.getString("password");
					System.out.println("pass:="+pass);
					if( (pass.equals(upassword)) )
					{
						Password_Status=1;
						break;
					}
					else
					break;
				}	
				stmt.close();
				DBH.DB_CLOSER(conn);
				if( (Password_Status==1))
				{
					/*session=request.getSession(false);
					if(session!=null)
					{
						response.sendRedirect("htmls/loged_in_pro.jsp");
					}
					else
					{*/
					session=request.getSession();
					session.setAttribute("uemail",uemail);

					response.sendRedirect("htmls/new_prop_list.jsp");
					//}
				}
				else
				{
				response.sendRedirect("htmls/user_login_page.html");
				}
				}
			catch(Exception e)
			{
				pw.println(e);
			}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}		
}
			