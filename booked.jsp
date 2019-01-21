

<%@page language="java" pageEncoding="UTF-8" %>
<%@ page language="java" import="fetch_session_details_pack.FETCH_SESSION_DETAILS"%>
<%@ page language="java" import="java.io.*"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="db_handler_package.DB_HANDLER"%>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="CART_PROP_PACK.CART_PROP" %>
<%@ page language="java" import="java.io.BufferedWriter" %>
<%@ page language="java" import="java.io.FileWriter" %>


<%! public String booking=null;
    public String strr=null;
%>
<%

                response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
                System.out.println("Hello i am in fetch session details");
                File file= new File("for_booking.txt");

                Scanner sc= new Scanner(file);
                while(sc.hasNextLine())
                {
                    booking=sc.nextLine();
                }

                sc.close();        
                    System.out.println("\n\n\nBOOOKING BUTTON  :-"+booking);
                    strr="<form action='http://localhost:8080/Site_ud/remove'><button name='go_back' value="+booking+" style='background-image: linear-gradient(to right,aqua,#ff1d8e);width:100%;border:none;border-radius: 30px;padding:10px;color:white;' id='hit'>Confirm</button></form>";
                    System.out.println("VALUE OF STRR :-"+strr);                

%>













<html>
    <head>
        <link rel="stylesheel" href="reset.css">
        <script src="jquery.js"></script>
        <script>
            $(document).ready(function(){
                
                $("#hit").click(function(){
                    alert("                              'Booking Successfull'    \n The Booking Details Will Be Shared With U Soon To Cancel Booking Contact The Agent In Details Shared");
                  
                });
            });
        </script>
    </head>
    <body>
        <table border="0" align="center" style="margin-top: 200px;">
            <tr>
                <td>
                    <div style="background-color:white;box-shadow: 0 4px 8px 0 rgba(0,0,0,0.6);border-radius: 20px;">
                        <table>
                            <tr>
                                <td style="text-align: center;">
                                    <font style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;font-size: 12px">Enter Card Number</font>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input stype="text" placeholder="Card Number" style="background:#e9e9e9;width:300px; border:none;border-radius: 30px;height:30px;font-family: 'Times New Roman', Times, serif;font-size: 15px;">
                                </td>
                            </tr>
                            <tr>
                                    <td style="text-align: center;">
                                        <font style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;font-size: 12px">Enter CVV</font>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input stype="password" placeholder="CVV" style="background:#e9e9e9;width:300px; border:none;border-radius: 30px;height:30px;">
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align: center;">
                                        <b><font style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;font-size: 12px">The Token Money To Paid is 5000 Rs For Buying and <br>900 Rs For Rental</font>  </b>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align: center;">
                                        <br>
                                            <!-- <input type="submit" class="book_btn" value="Book" style="background-image: linear-gradient(to right,aqua,#ff1d8e);width:100%;border:none;border-radius: 30px;padding:10px;color:white;">, -->
                                            
                                                <%
                                                System.out.println("VALUE OF STRR  AFTER:-"+strr);
                                                out.write(strr);
                                                %>
                                    </td>
                                </tr>
                                <tr>
                                        <td>

                                        </td>
                                    </tr>
                        </table>
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html>