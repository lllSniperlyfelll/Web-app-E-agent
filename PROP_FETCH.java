package PROPERTY_FETCH;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import db_duplicate_entry_verifier.VERIFY_DATA;
import java.lang.*;
import db_handler_package.DB_HANDLER;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class PROP_FETCH
{
    Connection com;
    String web_code;
    String card_code;
    String name1;
    public void session_name(String name)
    {
        try{
            name1=name;
        }
        catch(Exception e)
        {}
        
       // System.out.println("SESSON NAME SENT TO PROP_FETCH:-"+name1);
    }
    public String value_getter()
    {
        try{
        File file= new File("card_code.txt");

        Scanner sc= new Scanner(file);
        while(sc.hasNextLine())
        {
            web_code+=sc.nextLine();
        }
      // web_code.charAt(0)="";
       // System.out.println("CARD_CODE FROM VALUE_GETTER IN PROP_FETCH  :-"+web_code);
        sc.close();
        return (web_code);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return (web_code);
    }






    public String web_page_maker2(String address[],String price[],String area[],String imglink[],String prop_type[],String rating[])
    {
         int i=0;

            for(i=0;!(imglink[i].equals("data_ended"));i++)
                    {
                        /*System.out.println(address[i]);
                        System.out.println(area[i]);
                        System.out.println(price[i]);
                        System.out.println(imglink[i]);
                        System.out.println(prop_type[i]);*/
                       // System.out.println("==========");
                    }
        int max=0;
        int j=0;
        //System.out.println("declared i ,j , max");
        //String card_code="<div style=' box-shadow:0 5px 9px 0 rgba(0,0,0,0.1),0 6px 8px 0 rgba(0,0,0,0.120); width:380px;'><img src='../images/flate1.jpg' height='370px' width='380px'><center><br><b>text1</b><br><img src='../images/star-rating-test.jpg' height='20px' width='100px'><br><b>text2</b><br><b>text3</b></center> ";
        /*for (max=0; max<=6 ;max++)
        {
            System.out.println(address[max]);
        }*/

        /*for (max=0; !(imglink[max].equals("data_ended")) ;max++)
        {
            i=max;
            System.out.println("in i and max equality loop "+i);
        }*/
      
        /*System.out.println("idisplaying val of max");
        System.out.println("diaplaying val of i");
        System.out.println("i : "+i);*/
        for(j=0;j<=i;j++)
        {
            if( imglink[j].equals("data_ended"))
            {
                //System.out.println("imglink i :--------------------------------------"+imglink[i]);
                break;
            }
            else
            {
                
            String add=address[j];
            String price_str=price[j];
            String area_str=area[j];
            String imglnk=imglink[j];
            String p_type=prop_type[j];
            String rating_image=rating[j];
            rating_image="'"+(rating_image)+"'";
            imglnk="'"+(imglnk)+"'";
            //System.out.println(imglnk);
            card_code+= "<tr><td><br><br><br><br><br><div style='background-color: aquamarine;width: 800px;height:auto;border-radius:20px;' class='maindiv' id='hoverdiv'><table border='10'style='text-align: center' ><tr><td><img src="+imglnk+" style='height:230px;border-radius:20px; ' width='390px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td style='vertical-align: top'><table border='1' style='margin-top:10px;'><tr><td><input type='Submit' value="+p_type+" class='descbtnstyle' style='width:auto;'></td></tr><tr><td><br><br><font class='fontstyle'>"+add+"</font><br><font class='subfontstyle'></font><br><br></td></tr><tr><td><font class='Rfontstyle'>Ratings</font><img src="+rating_image+" width='90px' height='26px'></td></tr><tr><td><br><font class='subfontstyle'>"+price_str+"</font></td></tr></table></td></tr></table></div><center><table style='text-align: center;width:auto;' id='addtocartbtntable'><tr><td><form action='http://localhost:8080/Site_ud/ADD_TO_CART'><button value="+imglnk+" name='add_to_cart_btn' style= 'position:relative;outline:0;color:white;font-family: Segoe UI, Tahoma, Geneva, Verdana, sans-serif;  background-image:linear-gradient(to left,aqua,#ff1d8e);padding: 10px 150px;z-index:100000;border-bottom-left-radius: 30px;border-top-left-radius: 30px;border:none;' class='addtocartbtn'>Add To Cart</button><button name='Explore' style= 'border-bottom-right-radius: 30px;border-top-right-radius: 30px; padding: 10px 150px;z-index:100000;border:none; background-image:linear-gradient(to right,aqua,#ff1d8e);color:white;font-family: Segoe UI, Tahoma, Geneva, Verdana, sans-serif; outline:0;' value="+imglnk+" id='addtocartbtn11'>Explore</button></from>";
            //card_code+="<tr><td><br><br><br><br><br><div style='background-color: aquamarine;width: 800px;height:auto' class='maindiv'><table border='10'style='text-align: center'><tr><td><img src="+imglnk+" style='height:230px;' width='390px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td style='vertical-align: top'><table border='1' style='margin-top:10px;' ><tr><td><input type='Submit' value='Flats' class='descbtnstyle'></td></tr><tr><td><br><br><font class='fontstyle'>"+add+"</font><br><font class='subfontstyle'></font><br><br></td></tr><tr><td><font class='Rfontstyle'>Ratings</font><img src='../images/star-rating.png' width='70px' height='30px'></td></tr><tr><td><br><font class='subfontstyle'>Price</font></td></tr></table></td></tr></table></div></td></tr>";
            System.out.println("Value of j in prop_fetch "+j);                                               
            /*if( (j%3==0 && j!=0) )
                {
                    System.out.println("j divided : "+j);           
                    code+="</tr><tr>";
                    code+="<td style='padding-left: 50px;'><br><br><br>"+card_code+"</td>";
                }
            else
                {
                System.out.println("j : "+j);                    
                code+="<td style='padding-left: 50px;'><br><br><br>"+card_code+"</td>";
                }
        }
            
        code+="</tr></table>";*/
        //System.out.println(card_code);
                }
            }
          //  System.out.println("\n\n\nCARD_CODE  before tbalbe :-"+card_code);
        card_code="<table border='1' style='margin-top:100px;margin-left: 30px '>"+card_code+"</table>";
        //System.out.println("\n\n\nCARD_CODE  After table  :-"+card_code);
        return (card_code);
    
    //return("Nothing");
    }








    public String web_page_maker(String address[],String price[],String area[],String imglink[],String what_to_fetch,String rating1[])
    {
         int i=0;

            for(i=0;!(imglink[i].equals("data_ended"));i++)
                    {
                      /*  System.out.println(address[i]);
                        System.out.println(area[i]);
                        System.out.println(price[i]);
                        System.out.println(imglink[i]);*/
                       // System.out.println("==========");
                    }
        int max=0;
        int j=0;
        //System.out.println("declared i ,j , max");
        //String card_code="<div style=' box-shadow:0 5px 9px 0 rgba(0,0,0,0.1),0 6px 8px 0 rgba(0,0,0,0.120); width:380px;'><img src='../images/flate1.jpg' height='370px' width='380px'><center><br><b>text1</b><br><img src='../images/star-rating-test.jpg' height='20px' width='100px'><br><b>text2</b><br><b>text3</b></center> ";
        /*for (max=0; max<=6 ;max++)
        {
            System.out.println(address[max]);
        }*/

        /*for (max=0; !(imglink[max].equals("data_ended")) ;max++)
        {
            i=max;
            System.out.println("in i and max equality loop "+i);
        }*/
      
        /*System.out.println("idisplaying val of max");
        System.out.println("diaplaying val of i");
        System.out.println("i : "+i);*/
        for(j=0;j<=i;j++)
        {
            if( imglink[j].equals("data_ended"))
            {
                //System.out.println("imglink i :--------------------------------------"+imglink[i]);
                break;
            }
            else
            {
                
            String add=address[j];
            String price_str=price[j];
            String area_str=area[j];
            String imglnk=imglink[j];
            String rating_image=rating1[j];
            rating_image="'"+(rating_image)+"'";
            imglnk="'"+(imglnk)+"'";
            //System.out.println(imglnk);
            card_code+= "<tr><td><br><br><br><br><br><div style='background-color: aquamarine;width: 800px;height:auto;border-radius:20px;' class='maindiv' id='hoverdiv'><table border='10'style='text-align: center' ><tr><td><img src="+imglnk+" style='height:230px;border-radius:20px; ' width='390px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td style='vertical-align: top'><table border='1' style='margin-top:10px;'><tr><td><input type='Submit' value="+what_to_fetch+" class='descbtnstyle' style='width:auto;'></td></tr><tr><td><br><br><font class='fontstyle'>"+add+"</font><br><font class='subfontstyle'></font><br><br></td></tr><tr><td><font class='Rfontstyle'>Ratings</font><img src="+rating_image+" width='90px' height='26px'></td></tr><tr><td><br><font class='subfontstyle'>"+price_str+"</font></td></tr></table></td></tr></table></div><center><table style='text-align: center;width:auto;' id='addtocartbtntable'><tr><td><form action='http://localhost:8080/Site_ud/ADD_TO_CART'><button value="+imglnk+" name='add_to_cart_btn' style= 'position:relative;outline:0;color:white;font-family: Segoe UI, Tahoma, Geneva, Verdana, sans-serif;  background-image:linear-gradient(to left,aqua,#ff1d8e);padding: 10px 150px;z-index:100000;border-bottom-left-radius: 30px;border-top-left-radius: 30px;border:none;' class='addtocartbtn'>Add To Cart</button><button name='Explore' style= 'border-bottom-right-radius: 30px;border-top-right-radius: 30px; padding: 10px 150px;z-index:100000;border:none; background-image:linear-gradient(to right,aqua,#ff1d8e);color:white;font-family: Segoe UI, Tahoma, Geneva, Verdana, sans-serif; outline:0;' value="+imglnk+" id='addtocartbtn11'>Explore</button></from>";
            //card_code+="<tr><td><br><br><br><br><br><div style='background-color: aquamarine;width: 800px;height:auto' class='maindiv'><table border='10'style='text-align: center'><tr><td><img src="+imglnk+" style='height:230px;' width='390px'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td style='vertical-align: top'><table border='1' style='margin-top:10px;' ><tr><td><input type='Submit' value='Flats' class='descbtnstyle'></td></tr><tr><td><br><br><font class='fontstyle'>"+add+"</font><br><font class='subfontstyle'></font><br><br></td></tr><tr><td><font class='Rfontstyle'>Ratings</font><img src='../images/star-rating.png' width='70px' height='30px'></td></tr><tr><td><br><font class='subfontstyle'>Price</font></td></tr></table></td></tr></table></div></td></tr>";
          //  System.out.println("Value of j in prop_fetch "+j);                                               
            /*if( (j%3==0 && j!=0) )
                {
                    System.out.println("j divided : "+j);           
                    code+="</tr><tr>";
                    code+="<td style='padding-left: 50px;'><br><br><br>"+card_code+"</td>";
                }
            else
                {
                System.out.println("j : "+j);                    
                code+="<td style='padding-left: 50px;'><br><br><br>"+card_code+"</td>";
                }
        }
            
        code+="</tr></table>";*/
        //System.out.println(card_code);
                }
            }
           // System.out.println("\n\n\nCARD_CODE  before tbalbe :-"+card_code);
        card_code="<table border='1' style='margin-top:100px;margin-left: 30px '>"+card_code+"</table>";
       // System.out.println("\n\n\nCARD_CODE  After table  :-"+card_code);
        return (card_code);
    
    //return("Nothing");
    }

    String [] ResultSet_Generator(String Query,String field,Connection com )throws SQLException
    {
        try
        {
            System.out.println("\n\n I am In Result Set Generator \n\n");    
        int i=0;
        String result[]=new String[500];
      Statement stmt=com.createStatement();
      ResultSet rss=stmt.executeQuery(Query);
             while(rss.next())
              {
                  result[i]=rss.getString(field);
                 // System.out.println("RESULT SET OUTPUT FROM PROP_FETCH  :- "+result[i]);
                  i+=1;
              }
        result[i]="data_ended";
        rss.close();
        stmt.close();
        return(result);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    return(null);
    }


    public String decider(String what_to_fetch)
        {
            try
            {
                int i=0;
                String address_query=null;
                String price_query=null;
                String area_query=null;
                String imglink_query=null;
                String prop_type=null;
                String rating_query=null;
                String address[]=new String[500];
                String prop_type_arr[]=new String[500];
                String price[]=new String[500];
                String area[]=new String[500];
                String imglink[]=new String[500];
                String RATINGS[]=new String[500];
                DB_HANDLER DBH=new DB_HANDLER();
                com=DBH.DB_CONNECTOR();
                Statement stmt=com.createStatement();
                //data_ended
                
                if(  !(what_to_fetch.equals("fetch_all")) )
                {
                    if((what_to_fetch.equals("sale")))
                    {
                        what_to_fetch="'"+what_to_fetch+"'"+"AND booking !='booked'";
                        System.out.println("what_to_fetch :-"+what_to_fetch);
                        address_query="SELECT address from properties WHERE (prop_for= "+what_to_fetch+")";
                        System.out.println("addrerss query :-"+address_query);
                        price_query="SELECT price from properties WHERE (prop_for= "+what_to_fetch+")";
                        area_query="SELECT area from properties WHERE (prop_for= "+what_to_fetch+")";
                        imglink_query="SELECT imglink from properties WHERE (prop_for= "+what_to_fetch+")";
                        rating_query="SELECT rating from properties WHERE (prop_for= "+what_to_fetch+")";
                        
                        System.out.println("====================== QUERIERS FROM PROP FETCH ======================");
                        System.out.println(address_query);
                        System.out.println(price_query);
                        System.out.println(area_query);
                        System.out.println(imglink_query);
                        System.out.println(rating_query);
                        //System.out.println("Query:-"+Query);
                        address=ResultSet_Generator(address_query ,"address",com);
                        price=ResultSet_Generator(price_query,"price",com);
                        area=ResultSet_Generator(area_query,"area",com);
                        imglink=ResultSet_Generator(imglink_query,"imglink",com);
                        RATINGS=ResultSet_Generator(rating_query,"rating",com);
                        web_code=web_page_maker(address,price,area,imglink,what_to_fetch,RATINGS);
                    }
                    else if((what_to_fetch.equals("rental")))
                    {
                        what_to_fetch="'"+what_to_fetch+"'"+"AND booking !='booked'";
                        System.out.println("what_to_fetch :-"+what_to_fetch);
                        address_query="SELECT address from properties WHERE (prop_for= "+what_to_fetch+")";
                        System.out.println("addrerss query :-"+address_query);
                        price_query="SELECT price from properties WHERE (prop_for= "+what_to_fetch+")";
                        area_query="SELECT area from properties WHERE (prop_for= "+what_to_fetch+")";
                        imglink_query="SELECT imglink from properties WHERE (prop_for= "+what_to_fetch+")";
                        rating_query="SELECT rating from properties WHERE (prop_for= "+what_to_fetch+")";
                        
                        System.out.println("====================== QUERIERS FROM PROP FETCH ======================");
                        System.out.println(address_query);
                        System.out.println(price_query);
                        System.out.println(area_query);
                        System.out.println(imglink_query);
                        System.out.println(rating_query);
                        //System.out.println("Query:-"+Query);
                        address=ResultSet_Generator(address_query ,"address",com);
                        price=ResultSet_Generator(price_query,"price",com);
                        area=ResultSet_Generator(area_query,"area",com);
                        imglink=ResultSet_Generator(imglink_query,"imglink",com);
                        RATINGS=ResultSet_Generator(rating_query,"rating",com);
                        web_code=web_page_maker(address,price,area,imglink,what_to_fetch,RATINGS);
                    }
                    else
                    {
                what_to_fetch="'"+what_to_fetch+"'"+"AND booking !='booked'";
                System.out.println("what_to_fetch :-"+what_to_fetch);
                address_query="SELECT address from properties WHERE (prop_type= "+what_to_fetch+")";
                System.out.println("addrerss query :-"+address_query);
                price_query="SELECT price from properties WHERE (prop_type= "+what_to_fetch+")";
                area_query="SELECT area from properties WHERE (prop_type= "+what_to_fetch+")";
                imglink_query="SELECT imglink from properties WHERE (prop_type= "+what_to_fetch+")";
                rating_query="SELECT rating from properties WHERE (prop_type= "+what_to_fetch+")";
                
                System.out.println("====================== QUERIERS FROM PROP FETCH ======================");
                System.out.println(address_query);
                System.out.println(price_query);
                System.out.println(area_query);
                System.out.println(imglink_query);
                System.out.println(rating_query);
                //System.out.println("Query:-"+Query);
                address=ResultSet_Generator(address_query ,"address",com);
                price=ResultSet_Generator(price_query,"price",com);
                area=ResultSet_Generator(area_query,"area",com);
                imglink=ResultSet_Generator(imglink_query,"imglink",com);
                RATINGS=ResultSet_Generator(rating_query,"rating",com);
                web_code=web_page_maker(address,price,area,imglink,what_to_fetch,RATINGS);
                    }
                
                }


                else if(  (what_to_fetch.equals("fetch_all")) )
                {

                what_to_fetch="SELECT * FROM properties WHERE booking!='booked' ";
                System.out.println("SELECT * "+what_to_fetch);
                address=ResultSet_Generator(what_to_fetch ,"address",com);
                price=ResultSet_Generator(what_to_fetch,"price",com);
                area=ResultSet_Generator(what_to_fetch,"area",com);
                imglink=ResultSet_Generator(what_to_fetch,"imglink",com);
                prop_type_arr=ResultSet_Generator(what_to_fetch,"prop_type",com);
                RATINGS=ResultSet_Generator(what_to_fetch,"rating",com);
                System.out.println("Done !!!!");

                web_code=web_page_maker2(address,price,area,imglink,prop_type_arr,RATINGS);
                }
              //  System.out.println("\n\n\n===================THE FINAL WEB CODE:-=============================="+web_code);
                BufferedWriter bw;
                FileWriter fw;
                fw= new FileWriter("card_code.txt");
                bw= new BufferedWriter(fw);
                bw.write(web_code);
                bw.close();
                fw.close();
                DBH.DB_CLOSER(com);
                /*if(what_to_fetch.equals("flats"))
                { 
    
                    for(i=0;!(imglink[i].equals("data_ended"));i++)
                    {
                        System.out.println(address[i]);
                        System.out.println(area[i]);
                        System.out.println(price[i]);
                        System.out.println(imglink[i]);
                        System.out.println("==========");
                    }
                 
                
                }
                else if(what_to_fetch.equals("plot"))
                {

                }
                else if(what_to_fetch.equals("luxury_homes"))
                {

                }
                else if(what_to_fetch.equals("best_prize_props"))
                {

                }
                else if(what_to_fetch.equals("rental"))
                {

                }
                else if(what_to_fetch.equals("sale"))
                {

                }*/
            
            return(web_code);
        }
            catch(Exception e)
            {
                System.out.println(e);
            }
        return("<big><b> We Are Sorry We Got Nothing To Show!!! </b></big>");
        }
}



