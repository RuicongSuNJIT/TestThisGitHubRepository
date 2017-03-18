package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import connection.ConnectionOperation;

public class UserModel {
	public static boolean login(String username, String password) {
		final String QueryPassword = "select * from users where username=? and password=?";
		PreparedStatement queryPasswordStat;

		boolean result = false;
		Connection conn = null;
		ResultSet rs = null;
		conn = ConnectionOperation.getConnection();
		if (conn == null)
			return false;
		try {
			queryPasswordStat = conn.prepareStatement(QueryPassword);
			queryPasswordStat.setString(1, username);
			queryPasswordStat.setString(2, password);

 			rs = queryPasswordStat.executeQuery();
			result = rs.next();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean register(String username, String password, String email,String nickname) {
		final String defaultAvatar="/dinosaur/resource/avatar.jpg";
		final String checkUsername="select *from users where username=?";
		final String addUsersSQL = "insert into users(username,password,email,nickname,avatar) values (?,?,?,?,?)";//20170318
		PreparedStatement addUserStat;
		PreparedStatement checkUsernameStat;
		ResultSet rs=null;

		Connection conn = null;
		conn = ConnectionOperation.getConnection();
		int result = 0;
		if (conn == null)
			return false;
		try {
			checkUsernameStat=conn.prepareStatement(checkUsername);
			checkUsernameStat.setString(1, username);
			rs=checkUsernameStat.executeQuery();
			if(!rs.next()){
				return false;
			}
			
			addUserStat = conn.prepareStatement(addUsersSQL);
			addUserStat.setString(1, username);
			addUserStat.setString(2, password);
			addUserStat.setString(3, email);
			addUserStat.setString(4, nickname);//2017/03/18
			addUserStat.setString(5, defaultAvatar);

			result = addUserStat.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result!=0;
	}

	public static Map<String, String> getSessionBean(String username) {
		// TODO Auto-generated method stub
		final String getSessionQuery="select nickname,avatar from users where username=?";
		PreparedStatement queryStat;
		
		Map<String,String> map=new HashMap<>();
		Connection conn=null;
		ResultSet rs=null;
		conn=ConnectionOperation.getConnection();
		if(conn==null)
			return map;
		try {
			queryStat=conn.prepareStatement(getSessionQuery);
			queryStat.setString(1, username);
			rs=queryStat.executeQuery();
			map.put(username, username);
			map.put("nickname", rs.getString("nickname"));
			map.put("avatar", rs.getString("avatar"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return map;
	}
}
