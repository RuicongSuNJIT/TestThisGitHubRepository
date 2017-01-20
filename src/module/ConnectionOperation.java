package module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionOperation {
	private static final String URL = "jdbc:mysql://localhost:3306/share";
	private static final String USER = "root";
	private static final String PASS = "l19921016";

	// getConnection(),returns a connection object.
	public static Connection getConnection() {
		Connection conn;

		// load the jdbc_mysql driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql driver cannot be found!");
			e.printStackTrace();
			return null;
		}

		// connect to db,and get a conn object
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			System.out.println("cannot connect to db!");
			e.printStackTrace();
			return null;
		}
		if(conn!=null)
			System.out.printf("connect to db successfully:%nurl=%s",URL);
		return conn;
	}

	// close method
	public static void close(Connection conn) {
		if (conn == null)
			return;
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		if (rs == null)
			return;
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
