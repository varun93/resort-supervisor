package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/*
 * all the recurring functionalities such as creating a connection,
 * closing connection,result sets and preapared statements 
 * have been provided here.
 * fill the relevant url,password 
 * this is for oracle users,for MySQL users just change the url
 *  
 */
public class DBUtil {
	
	//private static String database_url= "jdbc:oracle:thin:@localhost:1521:XE";
	private static String database_url= "jdbc:mysql://localhost:8889/mysql";
	private static Connection connection;

	public DBUtil()
	{
		
		
	}
	
	
	public static  Connection getConnection()
	{
		
	  try {
		  
		  Class.forName("com.mysql.jdbc.Driver");
		//Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		
		connection = DriverManager.getConnection(database_url,"root","root");
		
		
	
		} catch (SQLException e) {
		
		e.printStackTrace();
	}
	catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}	
	  
	 return connection;
		
		
	}
	
	
	public static void closeConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeResultSet(ResultSet rs)
	{
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void closePreparedStatement(PreparedStatement ps)
	{
	
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
