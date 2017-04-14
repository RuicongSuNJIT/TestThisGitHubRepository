package moment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connection.ConnectionOperation;

public class MomentModel {

	public static int addComment(String text, String userId) {
		int commentNo = -1;
		final String SQL = "insert into comment(text,userId) values(?,?)";
		final String getNo = "select @@identity";
		Connection conn = ConnectionOperation.getConnection();
		if (conn == null) {
			return -1;
		}
		try {
			PreparedStatement stat = conn.prepareStatement(SQL);
			stat.setString(1, text);
			stat.setString(2, userId);
			stat.executeUpdate();

			PreparedStatement stat2 = conn.prepareStatement(getNo);
			ResultSet rs = stat2.executeQuery();
			if (!rs.next()) {
				return -1;
			}
			commentNo = rs.getInt(1);
			return commentNo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static boolean addFile(int commentNo, String filePath) {
		final String SQL = "INSERT INTO `share`.`files` (`filePath`, `commentNo`) VALUES (?, ?)";
		Connection conn = ConnectionOperation.getConnection();
		if (conn == null) {
			return false;
		}
		try {
			PreparedStatement stat = conn.prepareStatement(SQL);
			stat.setString(1, filePath);
			stat.setInt(2, commentNo);
			int res = stat.executeUpdate();
			return res != 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
