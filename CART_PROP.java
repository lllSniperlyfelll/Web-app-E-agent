package CART_PROP_PACK;

import java.util.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import db_handler_package.DB_HANDLER;







public class CART_PROP
{
    String card_code="";
    String address=null;
    String area=null;
    String price=null;
    String image_link=null;
    String query=null;
    Connection com;
    public String card_maker(String user_cartt[],int max)
    {

        try
        {
            int j=0;
            int count=0;
            int flagg=0;
            DB_HANDLER DBH=new DB_HANDLER();
                com=DBH.DB_CONNECTOR();
                //data_ended
                System.out.println("\n\n\nLength of User_Cart_Array:- "+user_cartt.length);
                /*for(int i=0;!(user_cartt[i].equals("endd"));i++)
                {
                    if(user_cartt[i]==null || user_cartt.equals(null))
                    System.out.println("I GOT THE NULL VALUE ");


                    System.out.println("SEARCHING :-  ");
                }*/
                /*if((user_cartt.length)<=2)
                {
                    for(int i=0;i<user_cartt.length;i++)
                    {
                    if(user_cartt[i]==null || user_cartt[i]=="")
                     {
                         System.out.println("Vlaue of Flag :-"+flagg);
                        flagg=1;
                     }
                    }
                    
                }
                if(flagg==1)
                    return("<tr><td>You Have Nothing In Your Cart Yet !!</td></tr>");*/
                for(int i=0;i<max;i++)
                {
                    if(user_cartt[i]!=null && !(user_cartt[i].equals("nothing")) && !(user_cartt[i].equals("?")) )    //!(user_cartt[i].equals("endd")) && !(user_cartt[i].equals("?")) )
                    {
                        //if(!(user_cartt[i].equals("deleted"))  && !(user_cartt[i].equals("end")))    
                        image_link="'"+user_cartt[i]+"'";
                        query="SELECT address,area,price FROM properties WHERE (imglink="+image_link+")";
                        System.out.println("\n\n================================== From CART_PROP======================== \n\n");                
                        System.out.println("Query :-"+query);
                        Statement stmt=com.createStatement();
                        ResultSet rss=stmt.executeQuery(query);
                            while(rss.next())
                            {
                                address=rss.getString("address");
                                System.out.println("Address is :-"+address);
                                /*result[i]=address;
                                i++;
                                count++;*/
                                area=rss.getString("area");
                                System.out.println("area is :-"+area);
                                
                                price=rss.getString("price");
                                System.out.println("price :-"+price);  
                            
                            }
        card_code+="<tr><td><br><br><center><center><div class='divstyle1'><table  cellspacing='0' cellpadding='0' align='center' style='width: 100%; height:200px; '><tr><td><img src="+image_link+" height='200px' width='300px'></td><td ><font size='3' face='elephant'><b>location: </b>"+address+"<br><br><b>Rate: </b>60 Lakhs<br><br><b>Area :"+area+" </b><br><br></font></td><TD style='vertical-align: top'><input type='submit' style='opacity: 0'></TD><TD style='vertical-align: top'><input type='submit' style='opacity: 0'></TD><TD style='vertical-align: top; '><br>  <form action='http://localhost:8080/Site_ud/remove'><button class='cancelbtn' style='top:0px;margin-top:0;' value="+image_link+" name='remove'></button></from></TD></tr><tr><td colspan='5' style='text-align: center;' rowspan='2'> <form action='http://localhost:8080/Site_ud/remove'><button value="+image_link+" name='book_btn'style= 'position:relative;outline:0;color:white;font-family: Segoe UI, Tahoma, Geneva, Verdana, sans-serif;  background-image:linear-gradient(to left,aqua,#ff1d8e);padding: 10px 150px;z-index:100000;border-radius: 30px;border-top-left-radius: 30px;border:none;' class='addtocartbtn'>Confirm Booking</button></from></td></tr><tr><td></td></tr></table></div><br><br><br></td></tr>";
                     
                    }
                    else if( (user_cartt[i].equals("?"))  && max==1)
                    {
                        card_code="<tr><td style='text-align:center'><marquee><font style='font-weight:bolder;color:#ff1d8e;font-size:22px;'>You Have Nothing In Your Cart !!</font></marquee></td></tr>";
                        break;
                    }

                }
        return(card_code);
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        return(card_code);
    } 
}