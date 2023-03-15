package test.morningtest.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	private final String HOST = "localhost";
	private final String PORT = "3306";
	private final String DBNAME = "myblog";
	private final String CHARSET = "UTF-8";
	private final String USER_NAME = "bloguser";
	private final String PASSWORD = "1q2w3e4r5t";

	Connection conn;

	public Connection getConnection() {
		if (conn == null) {
			String sqlFormat = "jdbc:mysql://%s:%s/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(sqlFormat, HOST, PORT, DBNAME, CHARSET);

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
				System.out.println("연결완료");
			} catch (Exception e) {
				System.out.println("helper에서 에러");
				e.printStackTrace();
			}
		}
		return conn;
	}

	public void getCloseConnection() {
		if(conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
