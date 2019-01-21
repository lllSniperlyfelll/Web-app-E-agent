package ADD_TO_CART_PACK;



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
import jdk.nashorn.internal.ir.Flags;
import session_handler.SESSION_CREATOR;




public class ADD_TO_CART_SERVLET extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
        int flaggg=0;
				try
				{		
                    String name=null,immm;				
					response.setContentType("text/html");
                    PrintWriter pw = response.getWriter();
                    HttpSession session=null;
                    session=request.getSession();
                    name=(String)(session.getAttribute("uemail"));
                    System.out.println("name from add to cart call:-"+name);
                    String image_link=request.getParameter("add_to_cart_btn");
                    immm=request.getParameter("Explore");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++value of add to cart btn:-"+image_link);
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++value of Explore btn:-"+immm);
                    if(name==null)
                        {
                            if(immm!=null)
                            {
                                BufferedWriter bw;
                                FileWriter fw;
                                fw= new FileWriter("for_pro_desc.txt");
                                bw= new BufferedWriter(fw);
                                bw.write(immm);
                                bw.close();
                                fw.close();
                                response.sendRedirect("htmls/pro_desc.jsp");    
                            }
                            response.sendRedirect("htmls/user_login_page.html");
                        }
                    else if(name!=null)
                    {
                        if(immm!=null)
                        {
                            BufferedWriter bw;
                            FileWriter fw;
                            fw= new FileWriter("for_pro_desc.txt");
                            bw= new BufferedWriter(fw);
                            bw.write(immm);
                            bw.close();
                            fw.close();
                            response.sendRedirect("htmls/pro_desc.jsp");    
                        }
                        else
                        {
                        int flag_check=0;
                        Connection con;
                        ResultSet rs;
                        Statement stmt;
                        PreparedStatement pstm;
                        String query;
                        String coll=">";
                        int parameter_no=900;
                        String name_proxy="'"+(name)+"'";
                        String image_link_proxy;
                        image_link_proxy=image_link;
                        image_link="'"+image_link+"'";
                        DB_HANDLER DBH=new DB_HANDLER();
                        con=DBH.DB_CONNECTOR();

                        query="SELECT * FROM USER_CART WHERE (EMAIL="+name_proxy+"AND IMAGE_LINK="+image_link+")";
                        stmt=con.createStatement();
                        rs=stmt.executeQuery(query);
                        while(rs.next())
                        {
                            if( (rs.getString("IMAGE_LINK").equals(image_link_proxy)))
                            {
                                flag_check=1;
                                break;
                            }
                        }

                        System.out.println("VALUE OF ALREDY ADDED PROP FLAG IN ADD TO CART :-"+flag_check);
                        if(flag_check==0)
                        {

                            System.out.println("Setted Proxy_name");
                            
                            query="INSERT INTO USER_CART (EMAIL,IMAGE_LINK) values("+name_proxy+","+image_link+")";
                            stmt=con.createStatement();
                            stmt.executeUpdate(query);
                            stmt.close();
                            System.out.println("\n\n stmt Closed");	
                            DBH.DB_CLOSER(con);        
                            System.out.println("\n\n cart Adding Query !!!!!FIRED!!!!:-"+query);
                            response.sendRedirect("htmls/cart.jsp");
    
                        }
                        else
                        {
                            response.sendRedirect("htmls/cart.jsp");
                        }
                        
                    }
                }
                
        }

                
                catch(Exception e)
                {
                    System.out.println(e);
                }
    }
        
}

    /*public String alert_box()
    {
        return("<center><table style='text-align: center;vertical-align: auto;margin-top: 200px' border='0'><tr><td><div class='alert'><span class='closebtn' > &times;&nbsp;&nbsp;</span><center><table border='0' style='width:180px;text-align: center;' align='center'><tr><td><br><br><font style='font-family: Segoe UI, Tahoma, Geneva, Verdana, sans-serif;font-weight: bold;'>Item Added To Cart</font></td></tr><tr><td><br><img src='../images/accept.png' height='20px' width='20px' style='border-radius: 100%'></td></tr></td></tr></table></center></div></table></center>");
    }*/

    