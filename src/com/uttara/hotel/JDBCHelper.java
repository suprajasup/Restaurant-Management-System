package com.uttara.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCHelper {

	public static Connection getConnection()
	{
		Connection con;
		try
		{
			Class.forName(Constants.DRIVER);
			con=DriverManager.getConnection(Constants.URL,Constants.UID,Constants.PASSWORD);
			return con;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeConnection(Connection con)
	{
		try
		{
		if(con!=null)
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void closeResultantSet(ResultSet rs)
	{
		try
		{
			if(rs!=null)
				rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void closeStatement(Statement s)
	{
		try
		{
			if(s!=null)
				s.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
