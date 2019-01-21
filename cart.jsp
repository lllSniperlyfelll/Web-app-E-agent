
<%@page language="java" pageEncoding="UTF-8" %>
<%@ page language="java" import="fetch_session_details_pack.FETCH_SESSION_DETAILS"%>
<%@ page language="java" import="java.io.*"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="db_handler_package.DB_HANDLER"%>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="CART_PROP_PACK.CART_PROP" %>


<%!
public int i=0;
public int count=0;
public String user_cart;
public String user_cartt_images[]=new String[500]; 
public String query;
public String first_name,middle_name,last_name,username,adhaar,dob,phno,user_address;
%>



<%

				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
                System.out.println("Hello i am in fetch session details");
				HttpSession session2=null;
                session2=request.getSession();
                username=(String)(session2.getAttribute("uemail"));
                System.out.println("name from cart:-"+username);
                CART_PROP CP=new CART_PROP();
               // pw.println("<br><a href='www.google.com'><table style='width:100%;text-align: right;'><tr><td colspan='2'><div style='float:right;height:auto; display:block;width: auto; background-image: linear-gradient(to right,#ff6666,#ffa5d2); backgroun;border-radius: 36px;z-index:10000000;'><table style='float:right;'><tr><td><center><img src='../images/user_default_profile.jpg' height='50px' width='50px' style='border-radius:100%;'></td><td style='text-align: top;vertical-align: top;'><font id='ff' style='color: white;font-size: 18px;font-family: Arial, Helvetica, sans-serif'><br>"+name+"</font></td></tr></table></div></td></tr></table></a>");
%>



<%
Connection con=null;
ResultSet rs;
Statement stmt;
ResultSet rs1;
Statement stmt1;
DB_HANDLER DBH=new DB_HANDLER();
con=DBH.DB_CONNECTOR();
		try
		{
            for(int k=0;k<user_cartt_images.length;k++)
            {
                user_cartt_images[k]="nothing";
            }
            query="SELECT FIRST_NAME,MIDDLE_NAME,LAST_NAME,ADHAAR_NUMBER,DATE_OF_BIRTH,user_address,phno FROM register WHERE EMAIL="+('"'+username+'"');
            System.out.println(query);
            stmt=con.createStatement();
            rs= stmt.executeQuery(query);
            while (rs.next())
            {
                first_name=rs.getString("first_name");
                first_name=first_name+" ";
                first_name+=rs.getString("middle_name");
                first_name=first_name+" ";
                first_name+=rs.getString("last_name");
                System.out.println("name from cart jsp : -"+first_name);
                adhaar=rs.getString("ADHAAR_NUMBER");
                dob=rs.getString("DATE_OF_BIRTH");
                user_address=rs.getString("user_address");
                phno=rs.getString("phno");
                
            }

            query="SELECT IMAGE_LINK FROM USER_CART WHERE EMAIL="+('"'+username+'"');
            System.out.println(query);
            stmt1=con.createStatement();
            rs1= stmt.executeQuery(query);
            int m=0;
            while (rs1.next())
            {
                //System.out.println("VALUE OF RESULT SET FROM CART JSP :- "+rs1.getString("IMAGE_LINK"));
                
                user_cartt_images[m]=rs1.getString("IMAGE_LINK");
                m+=1;
                
            }
            count=m;
            System.out.println("VALUE OF COUNT FROM CART JSP :-"+count);
            //user_cart=user_cart+",endd";

            stmt1.close();
            rs1.close();
            //user_cart=user_cart.replace(","," ");
            //user_cartt=user_cart.split(" ");
  
            int j=0;
            //System.out.println("user_cart Retrived and processed :-"+user_cart);
            for (int i=0; i<count ;i++)
	            {
                        System.out.println("User cart array with image link :-"+user_cartt_images[i]);
                           
                }
            
            DBH.DB_CLOSER(con);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        first_name="<td><center><font size='13' face='elephant' class='Rfontstyle'>"+first_name+"</font></center></td>";
        username="<td style='width:auto;'><center><img src='../images/profile_email.png' height='80px' width='80px'><br><p>"+username+"</p></center></td>";
        dob="<td style='width:auto;'><center><img src='../images/dob_logo.png' height='100px' width='100px'><br><p>"+dob+"</p></center></td>";
        adhaar="<td style='width:70%;'><center><img src='../images/adhaar.png' height='85px' width='85px' style='border-radius: 100%'><br><p><a href='#' style='text-decoration: none;color: black'>"+adhaar+"</a></p></center></td>";
        phno="<td style='width:70%;padding-right:200px '><center><img src='../images/phone.jpg' height='85px' width='85px' style='border-radius: 100%'><br><p><font style='color:black;'><a href='#' style='text-decoration: none;color: black'>"+phno+"</a></font></p></center></td>";
        user_address="<font style='font-size: 20px;'>"+user_address+"</font>";
%>


<html>
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, intial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.css">
        <script src="jquery.js"></script>
        <script>
        $(document).ready(function(){
            $("#logout").click(function(){
                if(confirm('Are You Sure You Want To LOGOUT ?'))
                {
                    alert("LOGOUT SUCCESSFULL");
                    $(location).attr('href',"http://localhost:8080/Site_ud/logoutt");
                }
            });
        });
        /*$(document).ready(function(){
            $(".cancelbtn").click(function(){
                if(confirm('Are You Sure You Want To remove ?'))
                {
                    alert("REMOVAL SUCCESSFULL");
                    $(location).attr('href',"http://localhost:8080/Site_ud/remove");
                }
            });
        });*/
        </script>
<style>
.logoout
{
color:white;
padding: 10px 100px;
transition: 0.9s;
}
.logoout:hover
{
color:black;
padding: 10px 105px;
transition: 1s;
}
    .bodystyle {
        background:linear-gradient(to bottom ,#673AB7,#FF4081);
        background-size:cover;
        background-repeat: no-repeat;
        background-attachment: fixed; 
            }
    
    .divstyle:hover
    {
        /*background: linear-gradient(to left,aqua,#ff1d8e);*/   
        border-radius: 10px;
        box-shadow: 0 4px 8px 0 rgba(0,0,0,0.5);
        width:100%;
        height:auto;
        transition: 2s;
    }

    .divstyle
    {
       background-color: white;
        border-radius: 10px;
        box-shadow: 0 4px 8px 0 rgba(0,0,0,0.5);
        width:100%;
        height:auto;
        transition: 2s;

    }

     .divstyle1
    {
       
        border-radius: 10px;
        box-shadow: 0 4px 8px 0 rgba(0,0,0,0.5);
        width:auto;
        height:auto;
    }
    .cancelbtn:hover
    {
        transition: 0.7s;
        background-color: crimson;
    }
    .cancelbtn
    {
        transition: 0.7s;
        border:0;
        top:0px;
        border-radius: 100%;
        padding: 20px 20px;
        background-image: url('../images/cancel_icon.png');
        background-size:cover;
        background-repeat:no-repeat;
        background-color: aqua;
    }

    .Rfontstyle
    {
        background: -webkit-linear-gradient(crimson,#ff1d8e);
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent; 
        font-size: 35;  
        font-family: elephant;  
    }

    
</style>
</head>

<body class="bodystyle" >

    
    <center>
    <div class="divstyle" style="position: sticky;z-index:100;">
    <table border='0' cellspacing='10' cellpadding='10' style="width: 100%; height:400px; " align='center'>
        <tr>
            <td style="width:100%; "><center><img src="..\images\user_default_profile.jpg" height="200px" width="200px" style="border-radius:100%;"></center>
                <br><br>
            </td>
           <% out.write(username); %>
           <% out.write(dob); %>

            <% out.write(adhaar); %>
            <% out.write(phno); %>
        </tr>
        <tr>
            <% out.write(first_name); %>
            <td colspan="3" style="text-align: right">
            
                    <input type="submit" id="logout" class="logoout" value="Logout" style="font-size:18px;font-family: Segoe UI, 'Tahoma', Geneva, Verdana, sans-serif;border-radius: 30px;border:0px;background-image: linear-gradient(to right,aqua,#ff1d8e);">
                    
            </td>
        </tr>
        <tr>
            <td colspan='5'><font style="font-size:30;" face="Copperplate Gothic Bold" color="#a8a8a8">YOUR ADDRESS : <% out.write(user_address); %></font>
            &nbsp; &nbsp;</td>
        </tr>
   </table>
</div>
</center>
<br><br><br>

<center>

<div style="height:700px;width:75%;background-color: azure;border-radius: 20px ;overflow-y: scroll;">


<br>
<br>
<center>
    <center>
         
                    <table border="0" style="width: 100%;" cellspacing="10">
                        <%  out.write(CP.card_maker(user_cartt_images,count));   %>
                    </table>
                    </div>
                    <br><br><br><br><br><br><br><br><br><br><br>
                    <center>
                        <div class="footer" style="background-color: white;width:100%;height:auto;">
                            <img src="..\images\logo.jpg" width="140px" height="140px"><br>
                            <font face="BrowalliaUPC">Privacy Policy | Terms of Use</font>
                            <br> 
                            <font face="BrowalliaUPC">@ Copyright 2018 Century 21 Department Store</font>
                    
                        </div>
                    </center>
                    
  
</body>
</html>