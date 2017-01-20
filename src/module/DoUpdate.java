package module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoUpdate {
	private static final String addUsersSQL="insert into users(username,password,email) values (?,?,?)";
	private static PreparedStatement addUserStat;
	
	public static int addUsers(String username,String password,String email){
		Connection conn=null;
		ResultSet rs=null;
		conn=ConnectionOperation.getConnection();
		int result=0;
		if(conn==null)
			return result;
		try{
			addUserStat=conn.prepareStatement(addUsersSQL);
			addUserStat.setString(1, username);
			addUserStat.setString(2, password);
			addUserStat.setString(3, email);

			result=addUserStat.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
}
