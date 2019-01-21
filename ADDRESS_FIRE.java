
import java.util.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import db_duplicate_entry_verifier.VERIFY_DATA;
import db_handler_package.DB_HANDLER;
//import detail_error_package.DETAIL_ERROR;

class ADDRESS_FIRE1
{

    void firee()
    {
            try
            {
                                Connection conn=null;
                                DB_HANDLER DBH=new DB_HANDLER();
								conn=DBH.DB_CONNECTOR();
								PreparedStatement pstm= conn.prepareStatement("INSERT INTO PROPERTIES(address,imglink) values(?,?)");	
								pstm.setString(1,"Golden next housing Society \n near estate building \nThane(west)");
								pstm.setString(2,"../images/flate1.jpg");
                                pstm.executeUpdate();
                                pstm.close();
                                DBH.DB_CLOSER(conn);

                                conn=DBH.DB_CONNECTOR();
                                PreparedStatement pstm1= conn.prepareStatement("INSERT INTO PROPERTIES(address,imglink) values(?,?)");	
								pstm1.setString(1,"Golden next housing Society \n near estate building \nThane(west)");
								pstm1.setString(2,"../images/flate2.jpg");
                                pstm1.executeUpdate();
                                pstm1.close();
                                DBH.DB_CLOSER(conn);

                                conn=DBH.DB_CONNECTOR();
                                PreparedStatement pstm2= conn.prepareStatement("INSERT INTO PROPERTIES(address,imglink) values(?,?)");	
								pstm2.setString(1,"Golden next housing Society \n near estate building \nThane(west)");
								pstm2.setString(2,"../images/flate3.jpg");
								pstm2.executeUpdate();
								System.out.println("Fired register");
								pstm2.close();
                                DBH.DB_CLOSER(conn);
            }
            catch(Exception e)
            {System.out.println(e);}
    }
}
class ADDRESS_FIRE
{
    public static void main(String arag[]){
        ADDRESS_FIRE1 ll= new ADDRESS_FIRE1();
        ll.firee();
    }
}								
							