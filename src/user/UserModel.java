package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.User;
import connection.ConnectionOperation;

public class UserModel {
	public static User login(String username, String password) {
		final String QueryPassword = "select nickname,avatar,id from users where username=? and password=?";

		Connection conn = ConnectionOperation.getConnection();
		if (conn == null)
			return null;

		try {
			PreparedStatement queryPasswordStat = conn.prepareStatement(QueryPassword);
			queryPasswordStat.setString(1, username);
			queryPasswordStat.setString(2, password);
			ResultSet rs = queryPasswordStat.executeQuery();
			if (!rs.next()) {
				return null;
			}
			User user = new User();
			user.setUsername(username);
			user.setNickname(rs.getString("nickname"));
			user.setAvatar(rs.getString("avatar"));
			user.setId(String.valueOf(rs.getInt("id")));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static boolean register(String username, String password, String email, String nickname) {
		final String defaultAvatar = core.Constants.DEFAULT_AVATAR;
		final String checkUsername = "select username from users where username=?";
		final String addUsersSQL = "insert into users(username,password,email,nickname,avatar) values (?,?,?,?,?)";// 20170318

		Connection conn = ConnectionOperation.getConnection();
		if (conn == null)
			return false;
		try {
			int result = 0;
			PreparedStatement checkUsernameStat = conn.prepareStatement(checkUsername);
			checkUsernameStat.setString(1, username);
			ResultSet rs = checkUsernameStat.executeQuery();
			if (rs.next()) {
				return false;
			}

			PreparedStatement addUserStat = conn.prepareStatement(addUsersSQL);
			addUserStat.setString(1, username);
			addUserStat.setString(2, password);
			addUserStat.setString(3, email);
			addUserStat.setString(4, nickname);// 2017/03/18
			addUserStat.setString(5, defaultAvatar);

			result = addUserStat.executeUpdate();
			return result != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public static User getUser(String username) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionOperation.getConnection();
		if (conn == null) {
			return null;
		}
		try {
			final String getSessionQuery = "select nickname,avatar,id from users where username=?";
			PreparedStatement queryStat = conn.prepareStatement(getSessionQuery);
			queryStat.setString(1, username);
			ResultSet rs = queryStat.executeQuery();
			if (!rs.next()) {
				return null;
			}
			User user = new User();
			user.setNickname(rs.getString(1));
			user.setAvatar(rs.getString(2));
			user.setId(rs.getString(3));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static User getUserbyId(int id) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionOperation.getConnection();
		if (conn == null) {
			return null;
		}
		try {
			User user = new User();
			final String getSessionQuery = "select username,nickname,avatar,id from users where id=?";
			PreparedStatement queryStat = conn.prepareStatement(getSessionQuery);
			queryStat.setInt(1, id);
			ResultSet rs = queryStat.executeQuery();
			if (!rs.next()) {
				return null;
			}
			user.setUsername(rs.getString(1));
			user.setNickname(rs.getString(2));
			user.setAvatar(rs.getString(3));
			user.setId(rs.getString(4));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
