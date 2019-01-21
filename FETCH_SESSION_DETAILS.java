package fetch_session_details_pack;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.http.HttpSession;
import db_handler_package.DB_HANDLER;
import session_handler.SESSION_CREATOR;

public class FETCH_SESSION_DETAILS extends HttpServlet
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
            try
            {
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
                System.out.println("Hello i am in fetch session details");
				HttpSession session=null;
                session=request.getSession();
                String name=(String)(session.getAttribute("uemail"));
                //System.out.println("name :-"+name);
                //pw.println("<a href='www.google.com'><div style='float:right;height:auto; display:block;width: auto; background-color: aqua ;border-radius: 36px;z-index:10000000;'><table style='float:right;'><tr><td ><center><img src='../images/user_default_profile.jpg' height='50px' width='50px' style='border-radius:100%;'></td><td style='text-align: top;vertical-align: top;'><font><br>"+name+"</font></td><td ><img src=''../images/arrow_right.png' height='50px' width='40px' style='float: right;'></td></tr></table></div></a>");
				//System.out.println(upassword);
                //System.out.println("session "+name);
                //if(name==null)
				//	{
                  //      response.sendRedirect("htmls/user_login_page.html");
                         //SESSION_CREATOR SC= new SESSION_CREATOR();
                        //SC.doGet(request,response);
						
				//	}
                //else if(name!=null)
                //{
                  //  response.sendRedirect("htmls/loged_in_pro.jsp");
               //}
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }
}