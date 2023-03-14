package test.testBlog.util;

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

	private Connection conn;

	private static DBHelper dbHelper;

	public static DBHelper getInstance() {
		if (dbHelper == null) {
			dbHelper = new DBHelper();
		}
		return dbHelper;
	}

	public Connection getConnection() {
		if (conn == null) {
			String urlFormat = "jdbc:mysql://%s:%s/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, HOST, PORT, DBNAME, CHARSET);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
				System.out.println("연결 완료");
			} catch (Exception e) {
				System.out.println("DBHelper에서 연결시점에 에러 발생");
				e.printStackTrace();
			}
		}
		return conn;
	}

	public void getCloseConnection() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println("DBHelper에서 닫는 시점에 에러 발생");
				e.printStackTrace();
			}
		}
	}
}
