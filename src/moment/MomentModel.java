package moment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Moment;
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

	public static ArrayList<Moment> getMomentsByUserId(int userId, int page) {
		int offset = page * 10;
		final String queryMoments = "SELECT no,text FROM comment WHERE userId=? LIMIT ?,10";

		ArrayList<Moment> moments = new ArrayList<>();
		Connection conn = ConnectionOperation.getConnection();
		if (conn == null) {
			return moments;
		}
		try {
			PreparedStatement stat = conn.prepareStatement(queryMoments);
			stat.setInt(1, userId);
			stat.setInt(2, offset);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				Moment m = new Moment();
				int commentId = rs.getInt("no");
				m.setCommentId(String.valueOf(commentId));
				m.setText(rs.getString("text"));
				m.setFiles(getFilesByCommentId(conn, commentId));
				moments.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionOperation.close(conn);
		}
		return moments;
	}

	private static ArrayList<String> getFilesByCommentId(Connection conn, int commentId) {
		final String queryfiles = "SELECT filePath FROM files where commentNo=?";
		ArrayList<String> files = new ArrayList<>();
		try {
			PreparedStatement stat = conn.prepareStatement(queryfiles);
			stat.setInt(1, commentId);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				files.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return files;
	}
}
