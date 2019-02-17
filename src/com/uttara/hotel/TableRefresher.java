package com.uttara.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TableRefresher implements Runnable
{

	public void run() 
	{

		while(true)
		{
			try 
			{
				Thread.currentThread().sleep(1000*180);// 
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			refresh();
		}
	}
	
	public void refresh()
	{
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=JDBCHelper.getConnection();

			if(con==null)
				throw new ConnectionException("There is a Problem With the DataBase Connectivity");
			else
			{
				
				Timestamp ts=Timestamp.valueOf(LocalDateTime.now().minusMinutes(1));//LocalDateTime.now().minusHours(2)
				
				
				String sql="update tables set bookingstatus='false', bookingtime=null where  bookingstatus='true' and bookingtime<='"+ts+"'";
				ps=con.prepareStatement(sql);
				ps.execute();
				
			}	
		} catch (ConnectionException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCHelper.closeStatement(ps);
			JDBCHelper.closeConnection(con);
		}
	}

}
