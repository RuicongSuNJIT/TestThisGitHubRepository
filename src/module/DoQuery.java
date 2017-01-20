package module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoQuery {
private static final String QueryPassword="select password from users where username=?";
private static PreparedStatement queryPasswordStat;

public static String getPassword(String username){
	String password=null;
	Connection conn=null;
	ResultSet rs=null;
	conn=ConnectionOperation.getConnection();
	if(conn==null)
		return null;
	try{
		queryPasswordStat=conn.prepareStatement(QueryPassword);
		queryPasswordStat.setString(1, username);
		
		rs=queryPasswordStat.executeQuery();
		password=rs.getString("password");
		System.out.println(password);
	}catch(SQLException e){
		e.printStackTrace();
	}
	return password;
}
}
