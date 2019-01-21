package db_handler_package;

import java.io.*;
import java.sql.*;
import java.util.*;


public class DB_HANDLER
{
Connection com=null;
	public Connection DB_CONNECTOR()
	{
		try
		{
		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		com=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_agent_db","root","");
		return(com);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(com);
	}
	
	public void DB_CLOSER(Connection com)
	{
		try
		{
		com.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}