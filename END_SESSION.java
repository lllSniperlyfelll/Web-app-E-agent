package end_session;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import javax.servlet.http.HttpSession;

public class END_SESSION extends HttpServlet
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				try
				{		
                    HttpSession session =request.getSession();
                    session.invalidate();
                    pw.println("<b><big>You Are loged Out</big></b>");
                    response.sendRedirect("welcome.html");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
    }
}








