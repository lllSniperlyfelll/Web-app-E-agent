import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import db_duplicate_entry_verifier.VERIFY_DATA;
import db_handler_package.DB_HANDLER;
//import detail_error_package.DETAIL_ERROR;

public class FETCH_REGRISTER_DATA extends HttpServlet
{
	
	/*void detail_error(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
	}*/
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
				try
				{						
					String first_name,middle_name,last_name,radio,email,password,dob_date,dob_month,dob_year,phno,landlineno,confirm_password,adhaarno,usr_address;
					first_name=request.getParameter("first_name");
					middle_name=request.getParameter("middle_name");
					last_name=request.getParameter("last_name");
					radio=request.getParameter("radio");
					email=request.getParameter("email");
					password=request.getParameter("password");
					dob_date=request.getParameter("dob_date");
					dob_month=request.getParameter("dob_month");
					dob_year=request.getParameter("dob_year");
					phno=request.getParameter("phno");
					landlineno=request.getParameter("landlineno");
					confirm_password=request.getParameter("confirm_password");
					adhaarno=request.getParameter("adhaarno");
					usr_address=request.getParameter("usr_address");
					System.out.println("========================================================");
					System.out.println("first name:"+first_name);
					System.out.println("middle name:"+middle_name);
					System.out.println("last name:"+last_name);
					System.out.println("radio:"+radio);
					System.out.println("email:"+email);
					System.out.println("password:"+password);
					System.out.println("date:"+dob_date);
					System.out.println("month:"+dob_month);
					System.out.println("year:"+dob_year);
					System.out.println("phno:"+phno);
					System.out.println("land line:"+landlineno);
					System.out.println("confirm pass:"+confirm_password);
					System.out.println("adhaar :"+adhaarno);
					System.out.println("address:"+usr_address);
					System.out.println("========================================================");
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					if(first_name.equals("") || last_name.equals("") || email.equals("") || password.equals("") ||confirm_password.equals("")||dob_date.equals("")||dob_month.equals("")||dob_year.equals("")||usr_address.equals("")||adhaarno.equals("") ||(phno.equals("") && landlineno.equals("")))
					{
						System.out.println("In All check if");
						response.sendRedirect("htmls/error_login_page.html");
					}
					else
					{
						int flag=0;
						String gender=null;
						Connection conn=null;
						Connection conn1=null;
						Connection conn2=null;
						Connection conn3=null;
						String date_of_birth=dob_date+"-"+dob_month+"-"+dob_year;
						VERIFY_DATA VD=new VERIFY_DATA();
						int email_check=VD.verify_email(email);
						int adhaarno_check=VD.verify_adhaarno(adhaarno);
						System.out.println(email_check);
						
						if( !(confirm_password.equals(password)))		//To check if password and confirm_password are equal or not
						{
							System.out.println(password);
							System.out.println(confirm_password);
							flag=1;
							System.out.println("In confirm password check if");
							response.sendRedirect("htmls/error_login_page.html");	
						}
						
						if(email_check==0)							//To Check Weather Email is unique or not
						{

							pw.println("Email ok :-<br>");
						}
						else
						{
							flag=1;
							System.out.println("In email check if");
							response.sendRedirect("htmls/error_login_page.html");
							pw.println("Email NOT ok :-<br>");
						}
						
						if(adhaarno_check==0)
						{
							int lenn=(adhaarno).length();
							if(lenn%12!=0)
							{
								
								flag=1;
								System.out.println("adhaar length :-"+lenn);
								System.out.println("In adhaar check if");
								response.sendRedirect("htmls/error_login_page.html");
							}
							else
							{
								pw.println("Adhaar ok :-<br>");
							}
						}
						if(radio.equals(""))
						{
							flag=1;
							System.out.println("In radio check if");
							
						}
						if( (phno.length())<10)
						{
							response.sendRedirect("htmls/error_login_page.html");
						}
						else
						{
							gender=radio;
						}
						
						if(flag==0){
							
							DB_HANDLER DBH=new DB_HANDLER();
								conn=DBH.DB_CONNECTOR();
								
								PreparedStatement pstm= conn.prepareStatement("INSERT INTO register(adhaar_number,first_name,middle_name,last_name,gender,date_of_birth,email,user_address,phno) values(?,?,?,?,?,?,?,?,?)");	
								pstm.setString(1,adhaarno);
								pstm.setString(2,first_name);
								pstm.setString(3,middle_name);
								pstm.setString(4,last_name);
								pstm.setString(5,gender);
								pstm.setString(6,date_of_birth);
								pstm.setString(7,email);
								pstm.setString(8,usr_address);
								pstm.setString(9,phno);
								pstm.executeUpdate();
								System.out.println("Fired register");
								pstm.close();
								
								String cart="nonee";
								conn1=DBH.DB_CONNECTOR();
								PreparedStatement pstm1= conn1.prepareStatement("INSERT INTO user_login(email,password) values(?,?)");
								pstm1.setString(1,email);
								//pstm1.setString(3,"?");
								pstm1.setString(2,password);
								//pstm1.setString(3,cart);
								pstm1.executeUpdate();
								System.out.println("Fired user_login");
								
								//String cart="nonee";
								
								Statement stmt;
								String query,email_proxy;
								email_proxy="'"+email+"'";
								conn3=DBH.DB_CONNECTOR();
								query="INSERT INTO USER_CART(email,image_link) values("+email_proxy+",'?')";
								stmt=conn3.createStatement();
								stmt.execute(query);
								//stmt.close();
								System.out.println("Fired user_login");


								//Statement stmt;
								String adhaar,mobile,landline;
								adhaar="'"+adhaarno+"'";
								mobile="'"+phno+"'";
								landline="'"+landlineno+"'";
								conn2=DBH.DB_CONNECTOR();
								query="INSERT INTO phone_numbers(adhaar_number,mobile_number,landline_number) values("+adhaar+","+mobile+","+landline+")";
								stmt=conn2.createStatement();
								stmt.execute(query);
								stmt.close();
								System.out.println("Fired user_login");

								/*conn2=DBH.DB_CONNECTOR();
								PreparedStatement pstm2= conn2.prepareStatement("INSERT INTO phone_numbers(adhaar_number,mobile_number,landline_number) values(?,?,?)");
								pstm2.setString(1,adhaarno);
								pstm2.setString(2,phno);
								pstm2.setString(3,landlineno);
								pstm2.executeUpdate();
								System.out.println("Fired phone_numbers");
								pstm2.close();*/
								
								DBH.DB_CLOSER(conn);
								DBH.DB_CLOSER(conn1);
								DBH.DB_CLOSER(conn2);
								response.sendRedirect("htmls/user_login_page.html");
						}
					}
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
	