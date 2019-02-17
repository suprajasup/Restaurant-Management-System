package com.uttara.hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Model {

	// To get The List of Restaurants 
	public List<HotelBean> getRestaurantList() throws ConnectionException, SQLException
	{

		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<HotelBean>l=new LinkedList<HotelBean>();
		try
		{
			con=JDBCHelper.getConnection();

			if(con==null)
				throw new ConnectionException("There is a Problem With the DataBase Connectivity");
			else
			{
				int slno;
				String  restaurant_name="";
				String sql="select * from restaurant";
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next())
				{
					slno=rs.getInt("slno");
					restaurant_name= rs.getString("restaurant_name");
					double rating=rs.getDouble("rating");
					
					HotelBean hd=new HotelBean(slno,restaurant_name,rating);
					l.add(hd);
				}

			}


			return l;


		}
		finally
		{
			JDBCHelper.closeResultantSet(rs);
			JDBCHelper.closeStatement(ps);
			JDBCHelper.closeConnection(con);
		}

	}


	// To get The List of Table Of a Particular Hotel

	public List<TableBean> getTableList(int hotelslno) throws ConnectionException, SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<TableBean>l=new LinkedList<TableBean>();
		try
		{
			con=JDBCHelper.getConnection();

			if(con==null)
				throw new ConnectionException("There is a Problem With the DataBase Connectivity");
			else
			{
				int slno;
				String  restaurant_name="";
				int no_of_seats;
				String sql="select * from tables where resslno="+hotelslno+" and bookingstatus='false'";
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next())
				{
					slno=rs.getInt(1);
					restaurant_name= rs.getString(2);
					no_of_seats=rs.getInt(7);
					TableBean  tb=new TableBean(slno,restaurant_name,no_of_seats,hotelslno);
					l.add(tb);
				}

			}	
			return l;
		}
		finally
		{
			JDBCHelper.closeResultantSet(rs);
			JDBCHelper.closeStatement(ps);
			JDBCHelper.closeConnection(con);
		}
	}

	// To Get The Registered Detail Of Customer
	public String getCustomerDetail(CustomerBean cb ) throws ConnectionException, SQLException
	{
		String msg=cb.validate();
		if(msg.equals(Constants.SUCESS))
		{
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			try
			{
				con=JDBCHelper.getConnection();
				if(con==null)
				{
					throw new ConnectionException("There is a Problem in Connection");
				}
				else
				{
					ps=con.prepareStatement("insert into customer(name,number,address)values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, cb.getUname());
					ps.setString(2, cb.getNumber());
					ps.setString(3, cb.getAddress());
					ps.execute();
					rs=ps.getGeneratedKeys();
					System.out.println(rs);
					rs.next();
					int slno=rs.getInt("slno");
					String cusslno=String.valueOf(slno);
					return cusslno;
				}

			}
			finally
			{
				JDBCHelper.closeResultantSet(rs);
				JDBCHelper.closeStatement(ps);
				JDBCHelper.closeConnection(con);
			}
		}



		else
			return msg;

	}


	public void deleteTemperarryCustomer(int coslno) throws ConnectionException, SQLException {

		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=JDBCHelper.getConnection();
			if(con==null)
			{
				throw new ConnectionException("There is a Problem in Connection");
			}
			else
			{
				ps=con.prepareStatement("delete from customer where slno="+coslno);
				ps.execute();
			}
		}
		finally
		{
			JDBCHelper.closeResultantSet(rs);
			JDBCHelper.closeStatement(ps);
			JDBCHelper.closeConnection(con);

		}
	}
	public List< List<FoodBean>> getFoodList() throws ConnectionException, SQLException
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<List<FoodBean>> m=new ArrayList<List<FoodBean>>();
		List<FoodBean>veg=new ArrayList<FoodBean>();
		List<FoodBean>chiniese=new ArrayList<FoodBean>();
		List<FoodBean>mexicon=new ArrayList<FoodBean>();

		try
		{
			con=JDBCHelper.getConnection();
			if(con==null)
				throw new ConnectionException("There is a Problem with Connection");
			else
			{

				String sqlmenu="select * from food";
				ps=con.prepareStatement(sqlmenu);
				rs=ps.executeQuery();
				while(rs.next())
				{
					int fslno=rs.getInt(1);
					String foodname=rs.getString(2);
					int fmenuslno=rs.getInt(4);
					int foodprice=rs.getInt(3);

					FoodBean fb=new FoodBean(fslno, foodname, fmenuslno, foodprice);
					if(fb.getFmenuslno()==1)
						veg.add(fb);
					if(fb.getFmenuslno()==3)
						mexicon.add(fb);
					if(fb.getFmenuslno()==2)
						chiniese.add(fb);
				}

				m.add(veg);
				m.add( mexicon);
				m.add(chiniese);

			}
			return m;
		} 
		finally
		{
			JDBCHelper.closeResultantSet(rs);
			JDBCHelper.closeStatement(ps);
			JDBCHelper.closeConnection(con);


		}
	}


	public void saveConfirm(CustomerBean cb, int table_sl) throws SQLException, ConnectionException 
	{
		String msg=cb.validate();
		if(msg.equals(Constants.SUCESS))
		{
			Connection con=null;
			PreparedStatement ps=null,ps1=null;
			ResultSet rs=null;
			try
			{ // update  tables set  name='Table-1' ,cust_sl=0 where slno=0
				con=JDBCHelper.getConnection();
				if(con==null)
				{
					throw new ConnectionException("There is a Problem in Connection");
				}
				/*UPDATE "PUBLIC"."TABLES" SET cust_sl=9 where slno=1*/
				else
				{
					ps=con.prepareStatement("insert into customer(name,number,address)values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, cb.getUname());
					ps.setString(2, cb.getNumber());
					ps.setString(3, cb.getAddress());
					ps.execute();
					rs=ps.getGeneratedKeys();
					rs.next();
					
					Timestamp ts=Timestamp.valueOf(LocalDateTime.now());
					System.out.println(ts);
					int slno=rs.getInt("slno");
					ps1=con.prepareStatement("UPDATE TABLES SET cust_sl="+slno+" ,bookingTime=? ,bookingstatus=? where slno= "+table_sl);
					ps1.setTimestamp(1, ts);
					ps1.setBoolean(2, true);
					ps1.execute();
				}

			}
			finally
			{
				JDBCHelper.closeResultantSet(rs);
				JDBCHelper.closeStatement(ps);
				JDBCHelper.closeConnection(con);
			}
		}


	}


	public long getPrice(String[] sls) throws ConnectionException, SQLException 
	{

		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			con=JDBCHelper.getConnection();
			if(con==null)
			{
				throw new ConnectionException("There is a Problem in Connection");
			}
			else
			{


				ps=con.prepareStatement("select foodprice  from food  where fslno=? ");

				long totalPrice=0;

				for(String pr:sls)
				{
					ps.setInt(1, Integer.parseInt(pr));
					rs=ps.executeQuery();
					while(rs.next())
					{
					totalPrice=totalPrice+rs.getInt("foodprice");
					}
				}
				
				System.out.println(totalPrice);
				return totalPrice;
			}

		}
		finally
		{
			JDBCHelper.closeResultantSet(rs);
			JDBCHelper.closeStatement(ps);
			JDBCHelper.closeConnection(con);
		}

	}


	public void setRating(int hotelSl, double rating) throws ConnectionException, SQLException {
		
		Connection con=null;
		PreparedStatement ps=null,ps1=null;
		ResultSet rs=null;
		try
		{ 
			con=JDBCHelper.getConnection();
			if(con==null)
			{
				throw new ConnectionException("There is a Problem in Connection");
			}
			
			else
			{
			
				String sql1="SELECT rating FROM RESTAURANT where slno="+hotelSl;
				ps=con.prepareStatement(sql1);
				rs=ps.executeQuery();
				rs.next();
				double previousRating= rs.getDouble("rating");
				double currentRating=(previousRating+rating)/2;
				
				System.out.println(previousRating+" "+currentRating);
				String sql2="Update RESTAURANT SET rating="+currentRating + "where slno="+hotelSl;
				ps1=con.prepareStatement(sql2);
				ps1.execute();
			
				
				
			}
		}
		finally
		{
			JDBCHelper.closeResultantSet(rs);
			JDBCHelper.closeStatement(ps);
			JDBCHelper.closeConnection(con);
		}

		
		
	}


}
class ConnectionException extends Exception
{
	public ConnectionException()
	{
		super();
	}
	public ConnectionException(String arg0)
	{
		super(arg0);
	}
}