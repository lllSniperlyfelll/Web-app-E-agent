
<%@page language="java" pageEncoding="UTF-8" %>
<%@ page language="java" import="fetch_session_details_pack.FETCH_SESSION_DETAILS"%>
<%@ page language="java" import="java.io.*"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="PROPERTY_FETCH.PROP_FETCH" %>
<%@ page language="java" import="ADD_TO_CART_PACK.ADD_TO_CART_SERVLET" %>
<%!  public String name,name1; %>


<html>
    <head>
            <link rel='stylesheet' href="css/bootstrap.css">
            <link rel='stylesheet' href="reset.css">
        	<script src="jquery.js"></script>
	<script>
		$(document).ready(function(){
			$(".closebtn").click(function(){
				$(".alert").slideUp(500);
			});

		});


	
	
	

	</script>
<style>
.alert
{
box-shadow: 0 4px 8px 0 rgba(0,0,0,0.5);
text-align: center;
border:0;
border-radius: 10px;
height:230px;
width:230px;
padding:20 px;
background-color:#E0FFFF;
color:black;
margin-bottom:15px;
}
.closebtn
{
margin-left:15px;
color:black;
font-weight:bold;
float:right;
font-size:40px;
line-height:40px;
cursor:pointer;
transition:0.4s;
}

.closebtn:hover
{
color:black;
}
</style>
            
        <style>
            #majordiv
            {
                bottom:0px;
                left: 0px;
                background-color: aquamarine;
                width:100%;
                height:100%;
            }
            .maindivstyle
            {
                top:0;
                bottom:0; 
                height: 400px;
                width: 100%;
                /*background-color: rgba(185, 171, 171, 0.3);*/
                background-color: rgba(0,0,0,0.2);
                object-fit: cover;
                z-index: 10000;
            }
            .maindivstyle1
            {
                top:0;
                bottom:0; 
                height: 200px;
                width: 100%;
                background-color: rgba(0,0,0,0.3);
                /*background-color: rgba(185, 171, 171, 0.3);*/
                object-fit: cover;
                z-index: 100;
            }
            
                        
            .sidenav
            {
                border-radius: 20px;
            height:auto;
            width:0;
            position:fixed;
            z-index:10000;
            top:92px;
            left:0;
            background-color:#6a6a6a;
            overflow-x:hidden;
            box-shadow: 0 4px 8px (0,0,0,0.2);
            padding-top:60px;
            transition:0.3s;
            }

            .sidenav a{
            padding: 8px 8px 8px 32px;
            text-decoration:none;
            font-size:25;
            color:white;
            display:block;
            transition:0.3s;
            }

            .sidenav .closebtn
            {
            position:absolute;
            top:0;
            left:25px;
            font-size:36px;
            margin-right:50px;
            }
            .menulinks
                {
                    color:#b6b6b6;
                }
                .menulinks:hover
                {

                    color:#2196f3;
                    /*font-size: 39px;*/
                }
                #FLATS
                {
                    transition: 0.3s;
                    font-size: 28px;
                    padding:10px 39px;

                }
                #FLATS:hover
                {
                    font-size: 38px;
                    transition: 0.3s;
                    padding: 10px 39px;
                }
                .submitbtn
            {
                background-color: transparent;
                background-image: url('../images/menu_button.png ') ;
                background-size:100%; 
                width: 50px;
                height: 50px;
                border: 0px;
                border-radius: 100%;
                transition: 0.3s;
            }
            .descbtnstyle
        {
            border:0px;
            padding:10px 30px;
            font-size: 15px;
            border-radius: 5px;
            color: whitesmoke;
            font-family: elephant;
            background-image: linear-gradient(to bottom,#3232ff,#8DEEEE);
            /*background-image: linear-gradient(to right,#00BFFF,#8DEEEE);*/
        }
        .maindiv
        {
            background-image: linear-gradient(to right,#4c4cff,#8DEEEE);
            /*background-image: linear-gradient(to right,#d7d7d7,#e4e4e4);*/
        }
        .fontstyle
        {
            font-size: 15px;
            color: white;
            font-family: elephant;
        }
        .subfontstyle
        {
            font-size: 10px;
            color: #d3d3d3;
            font-family: elephant; 
        }
        .Rfontstyle
        {
            background: -webkit-linear-gradient(#ffff00,#ffd700);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            
            font-size: 15px;
            
            font-family: elephant;  
        }

        </style>
          <script>

                function opennav()
                {
                document.getElementById("mysidenav").style.width="200px";

                }
                
                function closenav()
                {
                document.getElementById("mysidenav").style.width="0px";

                }
            </script>
                   
    </head>

    <body background="../images/pro_list_background.jpg" style="background-size: 100% 410px;background-repeat:no-repeat;" >


        <div class="maindivstyle1" style="width:100%;height:410px;text-align: center;position:absolute;">
        <center> <img src="../images/logo.jpg" height="90px" width="90px" style='border-radius:100%' ></center>
            <table border="0" style="width:100%;height:100%;z-index:100">        
                    <tr>
                        <td>
                                <div>
                                        <table style="width:100%" border="1" align="left">
                                            <tr>
                                                <td>
                                                    <div style="width:100%"><!--<div style="text-align: left;width:70%;">
                                                                <font color="white">  menu</font> 
                                                        </div> -->
                                                        <div id="mysidenav" class="sidenav">
                                                                
                                                                <a href="javascript:void(0)" class="closebtn" onclick="closenav()">&times;</a>
                                                                <form action="http://localhost:8080/Site_ud/PROP_INTERMEDIATE">
                                                                    <button value="flat" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">Home</font></div></font></button><br>
                                                                <button value="flat" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">Flats</font></div></font></button><br>
                                                                <button value="Bungalow" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">Luxury</font></div></font></button><br>
                                                                <button value="plot" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">Plot</font></div></font></button><br>
                                                                
                                                                <button value="sale" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">ForSale</font></div></font></button><br>
                                                                <button value="rental" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">Rental</font></div></font></button><br>
                                                            </form>
                                                            <form action="login_page.html"><button value="flat" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">Register</font></div></font></button><br></form>
                                                            <form action="user_login_page.html"><button value="flat" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">Login</font></div></font></button><br></form>
                                                                
                                                            <form action="about_us.html"><button value="flat" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">FindUs</font></div></font></button><br></form>
                                                                

                                                                
                                                        </div>
                                                        
                                                        <div style="text-align: left;padding-left: 70px;">
                                                            <input type="Submit" onclick="opennav()" class="submitbtn" value="" id="submitbtn">
                                                        </div>
                                                    </div>
                                                </td>
                                        
                                                <td>
                                                    
                                                            <div style="text-align: right;width:70%;position:relative;">
                                                                <a href="about_us.html" class="hrefstyle"style="text-decoration: none"><font color="white" style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;font-size: 20px;font-weight: bolder;">  Contact us</font></a> 
                                                            </div>
                                                    </td>
                                            </tr>
                                        
                                        </table>
                                        <br><br><br><br><br><br><br><br><br><br><br><br>
                                        
                                                <table align="center">
                                                        <tr>
                                                            <td>
                                                                  <font color="white" face="Elephant" size="25px"><i>Live Life in your dream Home</i></font>  
                                                            </td>
                                                        </tr>
                                                    </table>
                                    </div>


<!-- inSERT LOGIN CODE HERE-->

<%
                PROP_FETCH PF= new PROP_FETCH();
                ADD_TO_CART_SERVLET ATCS =new ADD_TO_CART_SERVLET();
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
                System.out.println("Hello i am in fetch session details");
				HttpSession session1=null;
                session1=request.getSession();
               // System.out.println("SESSION   :-"+(session1.toString()) );
              name=(String)(session1.getAttribute("uemail"));
                
                System.out.println("name :-"+name);
                if(name!=null)
                                    {
                                        out.write("<br><table style='width:100%;text-align: right;'><tr><td colspan='2'><a href='http://localhost:8080/Site_ud/htmls/cart.jsp'><div style='float:right;height:auto; display:block;width: auto; background-image: linear-gradient(to right,#ff6666,#ffa5d2); backgroun;border-radius: 36px;z-index:10000000;'><table style='float:right;'><tr><td><center><img src='../images/user_default_profile.jpg' height='50px' width='50px' style='border-radius:100%;'></td><td style='text-align: top;vertical-align: top;'><font id='ff' style='color: white;font-size: 18px;font-family: Arial, Helvetica, sans-serif'><br>"+name+"</font></td></tr></table></div></a></td></tr></table>");
                                    }
                
%>
<!--                cardd                                                            -->
                                    <center>
                                   
                                    <% out.write(PF.value_getter()); %>
                                    
                                    </center>

                                    <br><br><br><br><br><br><br><br><br><br><br>
                                    <center>
                                        <div class="footer">
                                            <img src="..\images\logo.jpg" width="140px" height="140px"><br>
                                            <font face="BrowalliaUPC">Privacy Policy | Terms of Use</font>
                                            <br> 
                                            <font face="BrowalliaUPC">@ Copyright 2018 Century 21 Department Store</font>
                                    
                                        </div>
                                    </center>
                                   
                                        

                                    
    </body>
</html>