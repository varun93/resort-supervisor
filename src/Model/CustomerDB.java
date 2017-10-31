package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerDB {
	
	public static String getCheckin(String customerID)
	{

		Connection connection = DBUtil.getConnection();
		ResultSet result=null;
	    String query = "select check_in from Customer where customer_id=?";
	    try {
	    	
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, customerID);
			result = stmt.executeQuery();
			if(result.next() ==  true)
			{
				
				return result.getString("check_in");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
		return null;
		
	}
	

	public static String getCheckout(String customerID)
	{

		Connection connection = DBUtil.getConnection();
		ResultSet result=null;
	    String query = "select check_out from Customer where customer_id=?";
	    try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, customerID);
			result = stmt.executeQuery();
			if(result.next() ==  true)
			{
				
				return result.getString("check_out");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return null;
		
	}
	
	public static Customer getCustomerDetails(String customerID)
	{
		Connection connection = DBUtil.getConnection();
		Customer customer=null;
		ResultSet result=null;
	    String query = "select * from Customer where customer_id=?";
	    try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, customerID);
			result = stmt.executeQuery();
	     	while(result.next() ==  true)
			{
				customer = new Customer();
				customer.setId(result.getString("customer_id"));
				customer.setFirstName(result.getString("first_name"));
				customer.setMiddleName(result.getString("middle_name"));
				customer.setLastName(result.getString("last_name"));
				customer.setCity(result.getString("city"));
				customer.setState(result.getString("state"));
				customer.setAddress(result.getString("address"));
				customer.setContactNumber(result.getInt("phone_number"));
				customer.setCheckIn(result.getString("check_in"));
				customer.setCheckOut(result.getString("check_out"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    
	    
		return customer;
	
	}
	
	
	public static int insertCustomerDetails(Customer customer)
	{
		Connection connection = DBUtil.getConnection();
		int result=0;
		String query = "insert into Customer (customer_id,first_name,middle_name,last_name,city,state,address,phone_number,check_in) values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, customer.getId());
			stmt.setString(2, customer.getFirstName());
			stmt.setString(3, customer.getMiddleName());
			stmt.setString(4, customer.getLastName());
			stmt.setString(5, customer.getCity());
			stmt.setString(6, customer.getState());
			stmt.setString(7, customer.getAddress());
			stmt.setInt(8, customer.getContactNumber());
			stmt.setString(9, customer.getCheckIn());
			
			result = stmt.executeUpdate(); 
			query = "insert into Bill (customer_id) values(?)";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, customer.getId());
			result = stmt.executeUpdate(); 
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	
	
	
	
	

	public static void checkoutCustomer(String customerID)
	{
		String query = "update Customer set check_out=curdate()+'' where customer_id=?";
		Connection connection = DBUtil.getConnection();
		java.sql.PreparedStatement ps;
	    try
		{
			ps = connection.prepareStatement(query);
		    ps.setString(1, customerID);
			ps.executeUpdate();
			
			query="update Booking set customer_id=NULL where customer_id=?";
			ps = connection.prepareStatement(query);
		    ps.setString(1, customerID);
			ps.executeUpdate();
			
		
			
		}
		catch(SQLException E)
		{
			E.printStackTrace();
		}
		

		
	}
		
	
	
	
}
