package PROP_INTERMEDIATE_PACK;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.http.HttpSession;
import PROPERTY_FETCH.PROP_FETCH;;

public class PROP_INTERMEDIATE extends HttpServlet
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
        try
        {
        String name=null;
                response.setContentType("text/html");
                PrintWriter pw = response.getWriter();
                System.out.println("I am in PROP_INTERMEDIATE");
				
                PROP_FETCH PF=new PROP_FETCH();
                
                

                System.out.println("Hello i am in fetch session details");
				HttpSession session1;
                session1=request.getSession();
               // System.out.println("SESSION   :-"+(session1.toString()) );
              name=(String)(session1.getAttribute("uemail"));
                String btn=request.getParameter("index_btn");
                String flat_link=request.getParameter("FLATS");
                PF.session_name(name);
                System.out.println("flat_link "+flat_link);
                if(btn!=null && btn.equals("Find Out More"))
                {
                    btn="fetch_all";
                   
                    PF.decider(btn);
                }
                else
                {
                    PF.decider(flat_link);
                }

                response.sendRedirect("htmls/new_prop_list.jsp");
            }
            catch(Exception e)
            {
               // System.out.println(e);
            }
    }
}