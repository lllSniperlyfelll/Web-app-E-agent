package db_duplicate_entry_verifier;

import java.io.*;
import java.sql.*;
import java.util.*;

import db_handler_package.DB_HANDLER;


public class VERIFY_DATA 
{
	
	DB_HANDLER DBH=new DB_HANDLER();
	String query="SELECT FIRST_NAME,MIDDLE_NAME,LAST_NAME FROM register WHERE EMAIL="+username+'"';
	Connection con=DBH.DB_CONNECTOR();
	Connection con1=DBH.DB_CONNECTOR();
	
	public int verify_email(String email)
	{
		try
		{
		Statement stmt=con.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT email FROM user_login");
		while (rs.next())
		{
			String email1=rs.getString("email");
			System.out.println(email1);
			System.out.println(email);
			if(email.equals(email1))
			{
				//DBH.DB_CLOSER(con);
				System.out.println("returned 1");
				return (1);
			}
		}
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
	System.out.println("returned 0");
	return(0);
	}
	public int verify_adhaarno(String adhaarno)
	{
		try
		{
		Statement stmt=con1.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT adhaar_number FROM register");
		while (rs.next())
		{
			String adhaarno1=rs.getString("adhaar_number");
			if(adhaarno.equals(adhaarno1))
			{
				DBH.DB_CLOSER(con1);
				System.out.println("returned 1");
				return (1);
			}
		}
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
	System.out.println("returned 0");
	return(0);
	}
	
}
	