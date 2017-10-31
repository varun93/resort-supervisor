package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import View.sportsAndEntertainment;

import com.mysql.jdbc.PreparedStatement;

public class MenuDB {

	
	
	public static ArrayList<RestaurantFacility> getRestaurantItems()
	{
		
		Connection connection = DBUtil.getConnection();
		ArrayList<RestaurantFacility> list = new ArrayList<RestaurantFacility>();
		
		String query = "select item_code,item_name,item_cost from Restaurant_Faclity";
		ResultSet rs;
		
		
		try
		{
			java.sql.PreparedStatement stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			RestaurantFacility rf = new RestaurantFacility();
			rf.setItemCode(rs.getString("item_code"));
			rf.setItemName(rs.getString("item_name"));
			rf.setItemCost(rs.getInt("item_cost"));
		
			list.add(rf);	
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			
		}
		
		
		return list;
	}
	
	public static ArrayList<SportsEntertainmentFacility> getSportsFacililities()
	{
		
		Connection connection = DBUtil.getConnection();
		ArrayList<SportsEntertainmentFacility> list = new ArrayList<SportsEntertainmentFacility>();
		
		String query = "select item_code,item_name,item_cost from Sports";
		ResultSet rs;
		
		
		
		try
		{
			java.sql.PreparedStatement stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			SportsEntertainmentFacility rf = new SportsEntertainmentFacility();
			rf.setItemCode(rs.getString("item_code"));
			rf.setItemName(rs.getString("item_name"));
			rf.setItemCost(rs.getInt("item_cost"));
		
			list.add(rf);	
			
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			
		}
		
		
		return list;
	}
	
	
	public static ArrayList<SportsEntertainmentFacility> getEntertainment()
	{
		
		Connection connection = DBUtil.getConnection();
		ArrayList<SportsEntertainmentFacility> list = new ArrayList<SportsEntertainmentFacility>();
		
		String query = "select item_code,item_name,item_cost from Entertainment";
		ResultSet rs;
		
		
		
		try
		{
			java.sql.PreparedStatement stmt = connection.prepareStatement(query);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			SportsEntertainmentFacility rf = new SportsEntertainmentFacility();
			rf.setItemCode(rs.getString("item_code"));
			rf.setItemName(rs.getString("item_name"));
			rf.setItemCost(rs.getInt("item_cost"));
		
			list.add(rf);	
			
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			
		}
		
		
		return list;
	}
	
	public static void allotRoom(String customerID,int number,String roomType)
	{
		Connection connection = DBUtil.getConnection();
		String sql = "update Booking set customer_id=? where customer_id is NULL && room_type=? limit ?";
		java.sql.PreparedStatement ps;
		java.sql.ResultSet rs;
		int num=0;
		
		try
		{
			ps = connection.prepareStatement(sql);
			ps.setString(1, customerID);
			ps.setString(2, roomType);
			ps.setInt(3, number);
			ps.executeUpdate();
		   
			
		}
		
		catch(SQLException E)
		{
			E.printStackTrace();
		}
		
		
	}
	
	public static boolean areRoomsAvailable(String roomType,int number)
	{
		Connection connection = DBUtil.getConnection();
		String sql = "select count(*) as freeRooms from Booking where customer_id is NULL && room_type=?";
		java.sql.PreparedStatement ps;
		java.sql.ResultSet rs;
		int num=0;
		
		try
		{
			ps = connection.prepareStatement(sql);
			ps.setString(1, roomType);
			rs = ps.executeQuery();
		    if(rs.next() == true)
		    {
		    	
		     num = rs.getInt("freeRooms");
		    
		    }
			
		}
		
		catch(SQLException E)
		{
			E.printStackTrace();
		}
		
		return (number<=num);
	}
	
	public static int getSportsCost(String itemName)
	{
		Connection connection = DBUtil.getConnection();
		String sql = "select item_cost from Sports where item_name=?";
		java.sql.PreparedStatement ps;
		java.sql.ResultSet rs;
		int num=0;
		
		try
		{
			ps = connection.prepareStatement(sql);
			ps.setString(1,itemName);
			rs = ps.executeQuery();
		    if(rs.next() == true)
		    {
		    	
		     num = rs.getInt("item_cost");
		    
		    }
			
		}
		
		catch(SQLException E)
		{
			E.printStackTrace();
		}
		
		return num;
		
		
	}
	
	public static int getEntertainmentCost(String itemName)
	{
		Connection connection = DBUtil.getConnection();
		String sql = "select item_cost from Entertainment where item_name=?";
		java.sql.PreparedStatement ps;
		java.sql.ResultSet rs;
		int num=0;
		
		try
		{
			ps = connection.prepareStatement(sql);
			ps.setString(1,itemName);
			rs = ps.executeQuery();
		    if(rs.next() == true)
		    {
		    	
		     num = rs.getInt("item_cost");
		    
		    }
			
		}
		
		catch(SQLException E)
		{
			E.printStackTrace();
		}
		
		return num;
		
		
	}
	
	
	
	public static Integer getBookingCost(String customerID)
	{
	
		Connection connection = DBUtil.getConnection();
		java.sql.PreparedStatement ps;
		java.sql.ResultSet rs;
	    String sql = "select sum(`room_cost`) as roomCost from Booking where customer_id=?"; 
		try
		{
			ps = connection.prepareStatement(sql);
			ps.setString(1, customerID);
			rs = ps.executeQuery();
		    if(rs.next() == true)
		    {
		    	
		    return rs.getInt("roomCost");
		    
		    }
			
		}
		catch(SQLException E)
		{
			E.printStackTrace();
		}
		

		
		return 0;
		
	}
	

	
	
}
