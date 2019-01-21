
package remove_from_cart;



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
import java.io.BufferedWriter;
import java.io.FileWriter;





public class REMOVE_FROM_CART extends HttpServlet
{
    int position_to_remove=-1;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
				try
				{		

                    String name_proxy=null;
                    System.out.println("^%*%#@*%*&#%*&%#@*%#*@%#*%@#*&%&*@#ROAR@#(@#(%#@(%#%(@#(@#(*&@(#*^(@#*(@#(^#*(@(*#(@");
                    String user_cart[]=new String [500];
                    int i=0,j=0,count=0;
                    String name=null;
                    String cancel_btn=null; 	
                    String coll=null;			
                    String go_back=null;
					response.setContentType("text/html");
                    PrintWriter pw = response.getWriter();
                    HttpSession session=null;
                    session=request.getSession();
                    name=(String)(session.getAttribute("uemail"));
                    name_proxy="'"+(name)+"'";
                    cancel_btn=request.getParameter("remove");
                    go_back=request.getParameter("go_back");
                    System.out.println("VALUE OF GO_BACK :-"+go_back);
                    String book_btn=request.getParameter("book_btn");
                    System.out.println("VALUE OF BOOK_BTN:-"+book_btn);
                    if(book_btn!=null)
                    {
                        BufferedWriter bw;
                        FileWriter fw;
                        fw= new FileWriter("for_booking.txt");
                        bw= new BufferedWriter(fw);
                        bw.write(book_btn);
                        bw.close();
                        fw.close();
                        response.sendRedirect("htmls/booked.jsp");
                        return;
                    }
                    else
                    {
                    if(go_back!=null)
                    {

                        Connection con;
                        ResultSet rs;
                        Statement stmt;
                        PreparedStatement pstm;
                        String query;
                        String image_link=null;
                        File file= new File("for_booking.txt");

                        Scanner sc= new Scanner(file);
                        while(sc.hasNextLine())
                        {
                            image_link=sc.nextLine();
                        }

                        sc.close();
                      //  System.out.println("\n\n cart Adding Query :-"+query);
                        DB_HANDLER DBH=new DB_HANDLER();
                        con=DBH.DB_CONNECTOR();
                        //System.out.println("Setted Proxy_name");
                        //query="SELECT USER_CARTT FROM user_login WHERE EMAIL="+(name_proxy);
                        //System.out.println(query);
                        stmt=con.createStatement();
                        /*rs= stmt.executeQuery(query);
                        for(i=0;i<user_cart.length;i++)
                        {
                           // user_cart[i]="$";
                            //System.out.println("HAHAHAHA :- "+user_cart[i]);
                        }
                        while (rs.next())
                        {
                           coll=rs.getString("user_cartt");
                           System.out.println("Value of col :-" +coll);
                            
                        }

                        user_cart=coll.split(",");
                        System.out.println("Splitted coll");*/
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
                        /*String removed_str=null;
                        
                        removed_str=coll.replace(image_link, "deleted");
                        System.out.println("FILTERED STRING   :- "+removed_str);
                        removed_str="'"+removed_str+"'";*/
                        image_link="'"+image_link+"'";
                        query="DELETE FROM USER_CART WHERE IMAGE_LINK="+(image_link)+"AND EMAIL="+(name_proxy);
                        stmt.execute(query);
                        //image_link="'"+image_link+"'";
                        query="UPDATE properties SET booking='booked' WHERE imglink="+(image_link);
                        stmt.executeUpdate(query);
                        //System.out.println("\n\n converted array_list to string with prevoius string:-"+coll);
                        //System.out.println("\nParameter Number:-"+parameter_no);		
                        /*pstm.setString( parameter_no,(coll));
                        System.out.println("\n\n Set String Executed");	
                        pstm.executeUpdate();*/
                        ///System.out.println("\n\n Update Executed :-"+query);	
                        //pstm.close();
                        stmt.close();
                        //rs.close();
                        //System.out.println("\n\n stmt Closed");	
                        DBH.DB_CLOSER(con);        
                       /*System.out.println("\n\n cart Adding Query !!!!!FIRED!!!!:-"+query);*/
                        response.sendRedirect("htmls/cart.jsp");
                    

                    }
                    else
                    {
                    //System.out.println("name from add to cart call:-"+name);
                        Connection con;
                        ResultSet rs;
                        Statement stmt;
                        PreparedStatement pstm;
                        String query;
                        String image_link=request.getParameter("remove");
                        //String name_proxy="'"+(name)+"'";

                      //  System.out.println("\n\n cart Adding Query :-"+query);
                        DB_HANDLER DBH=new DB_HANDLER();
                        con=DBH.DB_CONNECTOR();
                        System.out.println("Setted Proxy_name");
                        //query="SELECT USER_CARTT FROM user_login WHERE EMAIL="+(name_proxy);
                        //System.out.println(query);
                        
                        /*rs= stmt.executeQuery(query);
                        for(i=0;i<user_cart.length;i++)
                        {
                           // user_cart[i]="$";
                            //System.out.println("HAHAHAHA :- "+user_cart[i]);
                        }
                        while (rs.next())
                        {
                           coll=rs.getString("user_cartt");
                           System.out.println("Value of col :-" +coll);
                            
                        }

                        user_cart=coll.split(",");*/
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
                        //String removed_str=null;
                        //removed_str=coll.replace(cancel_btn, "deleted");
                        //System.out.println("FILTERED STRING   :- "+removed_str);

                        image_link="'"+image_link+"'";
                        query="DELETE FROM USER_CART WHERE IMAGE_LINK="+(image_link)+"AND EMAIL="+(name_proxy);
                        //query=" user_login SET USER_CARTT= "+removed_str+" WHERE EMAIL="+(name_proxy);
                        stmt=con.createStatement();
                        stmt.execute(query);
                        stmt.close();
                        DBH.DB_CLOSER(con);        
                        response.sendRedirect("htmls/cart.jsp");
                    
                        }
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
    }

}
    