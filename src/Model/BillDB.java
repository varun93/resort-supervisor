package Model;

import Controller.BookingManager;
import Controller.Manager;
import Controller.ResortManager;
import Controller.RestaurantManager;
import Controller.SEManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*have provided a complete example 
 * for this one class.
 */
public class BillDB {

	
	public static Bill getBillDetails(String customerID)
	{
	
		Connection connection = DBUtil.getConnection();
		Bill bill=null;
		ResultSet result=null;
	    String query = "select * from Bill where customer_id=?";
	    try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, customerID);
			result = stmt.executeQuery();
	     	while(result.next() ==  true)
			{
	     		
				bill= new Bill();
				bill.setRestaurantCost(result.getInt("re_cost"));
				bill.setSeCost(result.getInt("se_cost"));
				bill.setBookingCost(result.getInt("booking_cost"));
				bill.setTotalCost(result.getInt("total_cost"));
				
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    
	    	return bill;
		
	}
	
	
 
	public static void updateTotalCost(String customerID)
	{
		Connection connection = DBUtil.getConnection();
		String sql = "update Bill set total_cost=se_cost+re_cost+booking_cost where customer_id=?";
		java.sql.PreparedStatement ps;
		
		try
		{
			ps = connection.prepareStatement(sql);
			ps.setString(1, customerID);
	    	ps.executeUpdate();
			
		   
		}
		
		catch(SQLException E)
		{
			E.printStackTrace();
		}
		
		
		
	}
	
	public static void updateBookingCost(Integer cost,String customerID)
	{
		
		Connection connection = DBUtil.getConnection();
		String sql = "update Bill set booking_cost=? where customer_id=?";
		java.sql.PreparedStatement ps;
		
		try
		{
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cost);
			ps.setString(2, customerID);
			ps.executeUpdate();
			updateTotalCost(customerID);
		   
		}
		
		catch(SQLException E)
		{
			E.printStackTrace();
		}
		
		
		
	}
	
	public static void updateRestarantCost(Integer cost,String customerID)
	{
		
		Connection connection = DBUtil.getConnection();
		String sql = "update Bill set re_cost=? where customer_id=?";
		java.sql.PreparedStatement ps;
		
		try
		{
			ps = connection.prepareStatement(sql);
			ps.setInt(1,cost);
			ps.setString(2, customerID);
			ps.executeUpdate();
			updateTotalCost(customerID);
		}
		
		catch(SQLException E)
		{
			E.printStackTrace();
		}
		
		
	}
	
	
	
	public static void updateSECost(Integer cost,String customerID)
	{
		
		Connection connection = DBUtil.getConnection();
		String sql = "update Bill set se_cost=? where customer_id=?";
		java.sql.PreparedStatement ps;
		
		try
		{
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cost);
			ps.setString(2, customerID);
			ps.executeUpdate();
			updateTotalCost(customerID);
		}
		
		catch(SQLException E)
		{
			E.printStackTrace();
		}
		
		
	}
	
	
	
	
	
}
