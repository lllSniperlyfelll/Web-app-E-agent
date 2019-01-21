import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


class COLLECTION_TEST1
{
void coll()
	{
		try
		{
		int i=0;
		String aa="";
		String str1[]=new String[100];
		String str2[]=new String[100];		
		Connection com=null;
		Collection<String> col=new ArrayList<String>();
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		com=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		col.add("pravleen1");
		col.add("singh1");
		col.add("rait1");
		PreparedStatement pstm= com.prepareStatement("INSERT INTO test_details(DETAILS) values(?)");	
		pstm.setString(1,col.toString());
		pstm.executeUpdate();
		pstm.close();
		Statement st=com.createStatement();
		ResultSet rs= st.executeQuery("SELECT DETAILS FROM test_details");
		while(rs.next())
		{
			aa=aa+rs.getString("DETAILS");
			aa=aa.replace("[",",");
			aa=aa.replace("]",",");
		}
		//System.out.println(aa);
		str1=aa.split(",");
		System.out.println("------------");
		for (i=0;i<str1.length;i++)
		{
			System.out.println(str1[i]);	
			System.out.println("----");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}

class COLLECTION_TEST
{
	public static void main(String asr[])
	{
	COLLECTION_TEST1 ll= new COLLECTION_TEST1();
	ll.coll();
	}
}