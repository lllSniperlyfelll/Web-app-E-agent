
package book_update_pack;



import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpSession;
import db_handler_package.DB_HANDLER;
import session_handler.SESSION_CREATOR;



public class BOOKED  extends HttpServlet
{
    int position_to_remove=-1;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
				try
				{		

                    System.out.println("^%*%#@*%*&#%*&%#@*%#*@%#*%@#*&%&*@#ROAR@#(@#(%#@(%#%(@#(@#(*&@(#*^(@#*(@#(^#*(@(*#(@");
                    String user_cart[]=new String [500];
                    int i=0,j=0,count=0;
                    String name=null;
                    String cancel_btn=null; 	
                    String coll=null;			
					response.setContentType("text/html");
                    PrintWriter pw = response.getWriter();
                    HttpSession session=null;
                    session=request.getSession();
                    name=(String)(session.getAttribute("uemail"));
                    cancel_btn=request.getParameter("go_back");
                    //System.out.println("name from add to cart call:-"+name);
                        Connection con;
                        ResultSet rs;
                        Statement stmt;
                        PreparedStatement pstm;
                        String query;
                        String image_link=request.getParameter("add_to_cart");
                        String name_proxy="'"+(name)+"'";

                      //  System.out.println("\n\n cart Adding Query :-"+query);
                        DB_HANDLER DBH=new DB_HANDLER();
                        con=DBH.DB_CONNECTOR();
                        System.out.println("Setted Proxy_name");
                        query="SELECT USER_CARTT FROM user_login WHERE EMAIL="+(name_proxy);
                        //System.out.println(query);
                        stmt=con.createStatement();
                        rs= stmt.executeQuery(query);
                        for(i=0;i<user_cart.length;i++)
                        {
                            user_cart[i]="$";
                            System.out.println("HAHAHAHA :- "+user_cart[i]);
                        }
                        while (rs.next())
                        {
                           coll=rs.getString("user_cartt");
                           System.out.println("Value of col :-" +coll);
                            
                        }

                        user_cart=coll.split(",");
                       /* 
                        for(i=0;;i++)
                            {

                                System.out.println("USER_CART On REMOVE :-"+user_cart[i]);
                                count++;

                            }
                            System.out.println("COUNTING :-"+count);                            
                        for(i=0;i<count;i++)
                        {
                            if( user_cart[i].equals(cancel_btn) )
                            {
                                
                                position_to_remove=i;
                                System.out.println("\n\nDATA TO BE REMOVED FROM :-"+position_to_remove);
                            }
                            else
                            System.out.println("\n\n SEARCHING FOR SIMILIARITIES ");
                        }
                            System.out.println("IMG LINK TO REMOVE :-"+cancel_btn);*/
                           // System.out.println("TESTING COUNT :-"+user_cart[count-1]);
                            //System.out.println("DATA TO BE REMOVED FROM :-"+position_to_remove);
                        /*coll=user_cart[count-1];
                        user_cart[count-1]=user_cart[position_to_remove];
                        user_cart[position_to_remove]=coll;
                        user_cart[count-1]="deleted";*/
                        /*String removed_str=user_cart[0];
                        for(i=0;i<count;i++)
                            {
                                removed_str=removed_str+","+user_cart[i+1];
                                System.out.println("DATA REMOVED:-"+user_cart[i]);
                            }
                            System.out.println("FILTERED STRING   :- "+removed_str);
                        */
                        String removed_str=null;
                        removed_str=coll.replace(cancel_btn, "deleted");
                        System.out.println("FILTERED STRING   :- "+removed_str);
                        removed_str="'"+removed_str+"'";
                        query="UPDATE user_login SET USER_CARTT= "+removed_str+" WHERE EMAIL="+(name_proxy);
                        stmt.executeUpdate(query);
                        //System.out.println("\n\n converted array_list to string with prevoius string:-"+coll);
                        //System.out.println("\nParameter Number:-"+parameter_no);		
                        /*pstm.setString( parameter_no,(coll));
                        System.out.println("\n\n Set String Executed");	
                        pstm.executeUpdate();*/
                        ///System.out.println("\n\n Update Executed :-"+query);	
                        //pstm.close();
                        stmt.close();
                        rs.close();
                        //System.out.println("\n\n stmt Closed");	
                        DBH.DB_CLOSER(con);        
                       /*System.out.println("\n\n cart Adding Query !!!!!FIRED!!!!:-"+query);*/
                        response.sendRedirect("htmls/cart.jsp");
                    

                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
    }

    /*public String alert_box()
    {
        return("<center><table style='text-align: center;vertical-align: auto;margin-top: 200px' border='0'><tr><td><div class='alert'><span class='closebtn' > &times;&nbsp;&nbsp;</span><center><table border='0' style='width:180px;text-align: center;' align='center'><tr><td><br><br><font style='font-family: Segoe UI, Tahoma, Geneva, Verdana, sans-serif;font-weight: bold;'>Item Added To Cart</font></td></tr><tr><td><br><img src='../images/accept.png' height='20px' width='20px' style='border-radius: 100%'></td></tr></td></tr></table></center></div></table></center>");
    }*/
}
    