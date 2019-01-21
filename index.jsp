
<%@page language="java" pageEncoding="UTF-8" %>
<%@ page language="java" import="fetch_session_details_pack.FETCH_SESSION_DETAILS"%>
<%@ page language="java" import="java.io.*"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="db_handler_package.DB_HANDLER"%>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="PROPERTY_FETCH.PROP_FETCH" %>


<% System.out.println("Iam in index.jsp");
response.setContentType("text/html");
PROP_FETCH PF= new PROP_FETCH();
%>



<html >
    <head>
        <link rel='stylesheet' href="htmls/reset.css">
        <style>
            html
            {
                min-width:1080px;
            }
              .bodystyle
            {
                background:url('images/welcome_background.jpg');
                -webkit-background-size:cover;
                -moz-background-size:cover;
                -moz-background-size:cover;
                background-size:cover;   
               background-repeat:no-repeat; 
            
            }
            .maindivstyle
            {
                top:0;
                bottom:0; 
                height: 100%;
                width: 100%;
                background-color: rgba(0,0,0,0.5);
                object-fit: cover;
                z-index: 10000;
            }
            .buttonstyle:hover
            {
            
                background-image: linear-gradient(to right,#ff1d8e,aqua);/*url("images/login_button.jpg");*/ 
                transition: 1s;
            }

             .buttonstyle1
            {
            
                background-image: linear-gradient(to right,#ff1d8e,aqua);/*url("images/login_button.jpg");*/ 
                transition: 1s;
            }
            
            .buttonstyle
            {
                
                background-image: linear-gradient(to right,aqua,#ff1d8e);/*url("images/login_button.jpg");*/ 
                background-size: 300px 50px ; 
                background-color: white;
                height: 50px;
                border-radius: 90px;
                width: 200px;
                border:0;
                transition: 1s;
            }

                        
            .sidenav
            {
            height:500px;
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
                   /* font-size: 39px;*/
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
                background-image: url('images/menu_button.png ') ;
                background-size:100%; 
                width: 50px;
                height: 50px;
                border: 0px;
                border-radius: 100%;
                transition: 0.3s;
            }

    </style>
        
    <script>

        function opennav()
        {
        document.getElementById("mysidenav").style.width="200px";
        document.getElementById("submitbtn").style.width="0%";
        document.getElementById("submitbtn").style.height="0%";
        }
        
        function closenav()
        {
        document.getElementById("mysidenav").style.width="0px";
        document.getElementById("submitbtn").style.width="50px";
        document.getElementById("submitbtn").style.height="50px";
        }
    </script>
    </head>
    <body class="bodystyle">
        <table border="0" style="width:100%;height:100%">
            <tr>
                <td>
                        <div class="maindivstyle">
                                <center><img src="images/logo.jpg" height="90px" width="90px" style='border-radius:100%' ></center>
                                <table style="width:100%">
                                    <tr>
                                        <td><center>
                                                <!--<div style="text-align: left;width:70%;">
                                                        <font color="white">  menu</font> 
                                                </div> -->
                                                <div id="mysidenav" class="sidenav" style="height:auto;border-radius: 20px;">
                                                                
                                                        <a href="javascript:void(0)" class="closebtn" onclick="closenav()">&times;</a>
                                                        <form action="http://localhost:8080/Site_ud/PROP_INTERMEDIATE">
                                                            <button value="flat" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">Home</font></div></font></button><br>
                                                        <button value="flat" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">Flats</font></div></font></button><br>
                                                        <button value="Bungalow" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">Luxury</font></div></font></button><br>
                                                        <button value="plot" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">Plot</font></div></font></button><br>
                                                        
                                                        <button value="sale" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">ForSale</font></div></font></button><br>
                                                        <button value="rental" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">Rental</font></div></font></button><br>
                                                    </form>
                                                    <form action="htmls/login_page.html"><button value="flat" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">Register</font></div></font></button><br></form>
                                                    <form action="htmls/user_login_page.html"><button value="flat" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">Login</font></div></font></button><br></form>
                                                        
                                                    <form action="htmls/about_us.html"><button value="flat" name="FLATS" id="FLATS" style="background:transparent;padding:auto auto;border:none; "><font class="menulinks"><div > <font color="white" face="Elephant">FindUs</font></div></font></button><br></form>
                                                        

                                                        
                                                </div>
                                                
                                                <div style="text-align: left;padding-left: 70px;">
                                                    <input type="Submit" onclick="opennav()" class="submitbtn" value="" id="submitbtn">
                                                </div>
                                        </td>
                                        <td>
                                                <center>
                                                    <div style="text-align: right;width:70%;position:relative;">
                                                            <a href="htmls/about_us.html" class="hrefstyle"style="text-decoration: none"><font color="white" style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;font-size: 20px;font-weight: bolder;">  Contact us</font></a> 
                                                    </div>
                                            </td>
                                    </tr>
                                </table>
                          
                                
                                <center>
                                   
                                    <br><br><br><br><br><br><br><br><br><br><br><br>
                                    <table border="0" cellpadding="100px">
                                            <tr>
                                                <td>
                                                    <center>
                                                    <div style="justify-content: center;align-items: center;display: table-cell;vertical-align: middle;border-radius: 100%" >
                                                          <font size="15px" face="Elephant" color="white"> Let Your Dream Home</font> 
                                                    </div></center>                                
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                        <center>
                                                                <div style="justify-content: center;align-items: center;display: table-cell;vertical-align: middle;" >
                                                                        <font size="15px" face="Elephant" color="white">Come  To You</font>
                                                                  </div>
                                                        </center>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <br>
                                                    <br>
                                                    <center>
                                                        <form action="http://localhost:8080/Site_ud/PROP_INTERMEDIATE">
                                                            <input type="submit" data-hover="->" name="index_btn" class="buttonstyle" value="Find Out More" style="color:white;font-size: 20px;" id="animbtn">
                                                       </form>
                                                        </center>
                                                </td>
                                            </tr>
                                        </table>
                            </center>
                        </div>
                </td>
            </tr>
        </table>

    </body>
</html>
