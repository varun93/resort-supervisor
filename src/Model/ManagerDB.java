package Model;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerDB {

	
	
	public static boolean validateManager(String userID,String userName,String desig)
	{

		int count=0;
		Connection connection = DBUtil.getConnection();
		java.sql.PreparedStatement ps;
		java.sql.ResultSet rs;
	    String sql = "select count(*) as userCount from Manager where id=? && name=?"; 
		try
		{
			ps = connection.prepareStatement(sql);
			ps.setString(1,userID);
			ps.setString(2, userName);
			rs = ps.executeQuery();
			if (rs.next() == true)
			{
				System.out.print("here");
			 if (rs.getInt("userCount") > 0)
			 {
				 
				 return true;
			 }
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		

	    return false;
	}
	
}
