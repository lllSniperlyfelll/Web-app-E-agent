
<%@page language="java" pageEncoding="UTF-8" %>
<%@ page language="java" import="fetch_session_details_pack.FETCH_SESSION_DETAILS"%>
<%@ page language="java" import="java.io.*"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import ="java.sql.*"%>
<%@ page language="java" import=" db_handler_package.DB_HANDLER"%>
<%@ page language="java" import="java.io.BufferedWriter"%>
<%@ page language="java" import="java.io.FileWriter"%>



<%! public String name=null; 
    public String image_link=null;
    public String address=null;
    public String price=null;
    public String area=null;
    public String prop_type=null;
    public String booking=null;
    public String plot_owner=null;
    public String bedrooms=null;
    public String hall=null;
    public String extra_rooms=null;
    public String since=null;
    public String near_by=null;



    int i=0;
    String result[]=new String[500];
    Connection com=null;
%>

<%
                try
                {
                response.setContentType("text/html");
                PrintWriter pw = response.getWriter();
                System.out.println("I am in pro_desc JSP");
                System.out.println("Hello i am in fetch session details");
                File file= new File("for_pro_desc.txt");

                Scanner sc= new Scanner(file);
                while(sc.hasNextLine())
                {
                    image_link=sc.nextLine();
                }
                sc.close();

                System.out.println("Explore button value:- "+image_link);
                HttpSession session1=null;
                session1=request.getSession();
                
                String address_query=null;
                String super_query=null;
                String all_details;
                DB_HANDLER DBH=new DB_HANDLER();
                com=DBH.DB_CONNECTOR();
             
                //data_ended
                image_link="'"+image_link+"'";
                super_query="SELECT * FROM properties WHERE (imglink="+image_link+")";
                System.out.println("super_query :-"+super_query);
                int count=0;
                System.out.println("\n\n From Pro_desc \n\n");                
                Statement stmt=com.createStatement();
                ResultSet rss=stmt.executeQuery(super_query);
                    while(rss.next())
                    {
                        address=rss.getString("address");
                        System.out.println("Address is :-"+address);
                        /*result[i]=address;
                        i++;
                        count++;*/
                        area=rss.getString("area");
                        System.out.println("area is :-"+area);
                        /*result[i]=area;
                        i++;
                        count++;*/
                        prop_type=rss.getString("prop_type");
                        System.out.println("prop_type :-"+prop_type);
                        /*result[i]=prop_type;
                        i++;
                        count++;*/
                        booking=rss.getString("booking");
                        System.out.println("booking :-"+booking);
                        /*result[i]=booking;
                        i++;
                        count++;*/
                        price=rss.getString("price");
                        System.out.println("price :-"+price);  
                       /* result[i]=price;
                        i++;
                        count++;*/

                        plot_owner=rss.getString("plot_owner");
                        System.out.println("plot_owner :-"+plot_owner);

                       
                        bedrooms=rss.getString("bedrooms");
                        System.out.println("bedrooms :-"+bedrooms);


                        hall=rss.getString("hall");
                        System.out.println("hall :-"+hall);



                        extra_rooms=rss.getString("extra_rooms");
                        System.out.println("extra_rooms :-"+extra_rooms);



                        since=rss.getString("since");
                        System.out.println("since :-"+since);


                        near_by=rss.getString("near_by");
                        System.out.println("near_by :-"+near_by);
                    

                    }
                System.out.println("Value of count :-"+count);
               // result[i]="data_ended";
                    for(i=0;i<count;i++)
                    {
                        System.out.println("Value in result of super_query  :-"+result[i]);
                    }
                DBH.DB_CLOSER(com);
                
                rss.close();
                stmt.close();
              
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
           




%>


<html>
    <head>

        <!--<link rel="stylesheet" href="reset.css">-->
            <link rel="stylesheet" href="css/bootstrap.css">
            <script src="jquery.js"></script>
            <script>
                $(document).ready(function(){
                    $("#logo_image").hide();
                    $("#add_bar").hide();
                    $("#e_agent_logo").hide();
                    $("#proverb").hide();
                    $("#underline_image").hide();
                   

                    $("#body").mouseover(function(){
                       
                        $("#e_agent_logo").slideDown(1000);
                        
                    });
                });
            </script>
            <script>
                $(document).ready(function(){
                  $("#body").mouseover(function(){
                        $("#proverb").slideDown(1000);
                        $("#underline_image").slideDown(1000);
                    });
                });
            </script>
            <script>
                $(document).ready(function(){
                    $("#body").mouseover(function(){
                        $("#logo_image").fadeIn(2000);
                        $("#add_bar").fadeIn(2000);
                    });
                    

                });
            </script>
        <style>
            .heading {color:crimson; size:12; text-align: center;}
            a {text-decoration:none; color:black; font-size: 12;}
            .content { background-color: white; box-shadow:0 4px 8px 0 rgba(0,0,0,0.2),0 6px 8px 0 rgba(0,0,0,0.17);}
        </style>
    </head>
    <body id="body">
            
            <div class="jumbotron" id="test" style="width:100%;height:400px;">
                    <center><img src="../images/logo.jpg" height="150px" width="150px" style="border-radius: 100%" id="e_agent_logo"></center>
            
                    <b><center><font face="Copperplate Gothic Bold" size="6" id="proverb"><b>Your First Step To Your Dream Home</b></font></center>
                    <div ><center><img src="../images/underline.png" height="60px" width="700px" id="underline_image"></center></div>
                    </div><br><br><br>
                    
            <table border='0' align='center'>
                <tr>
                    <td><img src="..\images\gps_logo.png" height="60px" width="60px" id="logo_image"><br></td>
                    <%
                    out.write("<td><div style='font-size: 30px;height:39px' ><font id='add_bar'>"+address+"</font></div><br></td>");
                    %>
                </tr>
            </table>
        <br><br>
        <table border="0" align='center'>
            <% out.write("<tr><td><center><img src="+image_link+" width='900px' height='500px' style='border-radius: 20px;' ></center></td></tr>"); %>
        </table>

        <br><br>
        <div class='content'>
        <table cellspacing="10" cellpadding="10"  align="center" width='1000px' border="0">
                <div class='heading'><tr><td  colspan="2"><strong><a href='#'>GENERAL</a></strong><hr color='blue' height='30px'></td></tr></div>
                <%
                out.write("<tr><td><img src='../images/accept.png' width='15px' height='15px'> Total Area  :</td><td>"+area+"</td></tr>");
                out.write("<tr><td><img src='../images/accept.png' width='15px' height='15px'> Bedrooms  :</td><td>"+bedrooms+"</td></tr>");
                out.write("<tr><td><img src='../images/accept.png' width='15px' height='15px'> Hall :</td><td>"+hall+"</td></tr>");
                out.write("<tr><td><img src='../images/accept.png' width='15px' height='15px'> Extra Rooms :</td><td>"+ extra_rooms+"</td></tr>");
                out.write("<tr><td><img src='../images/accept.png' width='15px' height='15px'> Price :<br></td><td>"+ price+"<br></td></tr>"); 
                %>
                
                <div id='heading'><tr><td  colspan="2"><strong><a href='#'>BUILDING INFO</a></strong><hr color='blue' height='20px'></td></tr></div>
                <%
                out.write("<tr><td><img src='../images/accept.png' width='15px' height='15px'> Building Since  :</td><td>"+since+"</td></tr>");
                out.write("<tr><td><img src='../images/accept.png' width='15px' height='15px'> Location :</td><td>"+ address+"</td></tr>");
                out.write("<tr><td><img src='../images/accept.png' width='15px' height='15px'> Land registered  :</td><td>in name of :  "+plot_owner+"</td></tr>");
                %>

                <div id='heading'><tr><td  colspan="2"><strong><a href='#'>NEARBY</a></strong><hr color='blue' height='20px'></td></tr></div>
              
                <tr>
                        <%
                    out.write("<td><img src='../images/accept.png' width='15px' height='15px'> Places :"+near_by+"</td>");
                    
                %>
                </tr>
                
                <% 
                System.out.println("\n\nNOW in pro_desc jsp and starting fetching session:\n\n");
                String name=(String)(session.getAttribute("uemail"));
                System.out.println("session name from prop_desc :-"+name); 
                if(name!=null)
                {
                    out.write("<tr><td colspan='2'><br><br><br><br><center><form action='http://localhost:8080/Site_ud/ADD_TO_CART'><button style= 'border-bottom-right-radius: 30px;border-radius: 30px; padding: 19px 290px;z-index:100000;border:none; background-image:linear-gradient(to right,aqua,#ff1d8e);color:white;font-family: Segoe UI, Tahoma, Geneva, Verdana, sans-serif; outline:0;' value="+image_link+" id='addtocartbtn1' name='add_to_cart_btn'>Add To Cart Here</button></form></center><br><br><br><br></td></tr>");
                }
                else if(name==null)
                {
                    out.write("<tr><td colspan='2'><br><br><br><br><center><form action='user_login_page.html'><button style= 'border-bottom-right-radius: 30px;border-radius: 30px; padding: 19px 290px;z-index:100000;border:none; background-image:linear-gradient(to right,aqua,#ff1d8e);color:white;font-family: Segoe UI, Tahoma, Geneva, Verdana, sans-serif; outline:0;' value="+image_link+" id='addtocartbtn1'>Login First</button></form></center><br><br><br><br></td></tr>");
                    //out.write("<tr><td colspan='2'><br><br><br><br><center><form action='user_login_page.html'><button style= 'border-bottom-right-radius: 30px;border-radius: 30px; padding: 19px 290px;z-index:100000;border:none; background-image:linear-gradient(to right,aqua,#ff1d8e);color:white;font-family: Segoe UI, Tahoma, Geneva, Verdana, sans-serif; outline:0;' value="+image_link+" id='addtocartbtn1'>Login First</button></form></center><br><br><br><br></td></tr>");
                }
                %>
                
        </table>
        </div>
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