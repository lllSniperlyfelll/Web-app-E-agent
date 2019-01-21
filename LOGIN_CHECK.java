import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.http.HttpSession;
import db_handler_package.DB_HANDLER;
import session_handler.SESSION_CREATOR;

public class LOGIN_CHECK extends HttpServlet
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
                System.out.println("Hello");
				HttpSession session=null;
                session=request.getSession();
                String name=(String)(session.getAttribute("uemail"));
                System.out.println("name :-"+name);
				//System.out.println(upassword);
                System.out.println("session "+name);
                if(name==null)
					{
                        response.sendRedirect("htmls/user_login_page.html");
                         //SESSION_CREATOR SC= new SESSION_CREATOR();
                        //SC.doGet(request,response);
						
					}
                else if(name!=null)
                {
                    response.sendRedirect("htmls/loged_in_pro.jsp");
                }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }
}