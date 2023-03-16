package url_db_test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	private final String HOST = "localhost";
	private final String PORT = "3306";
	private final String DBNAME = "placeholder";
	private final String CHARSET = "UTF-8";
	private final String USERNAME = "bloguser";
	private final String PASSWORD = "1q2w3e4r5t";

	Connection conn;

	public Connection getConnection() {

		if (conn == null) {
			String urlFormat = "jdbc:mysql://%s:%s/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, HOST, PORT, DBNAME, CHARSET);

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
				System.out.println("연결 완료");
			} catch (Exception e) {
				System.out.println("DBHelper:getConnection에서 오류 발생");
				e.printStackTrace();
			}
		}

		return conn;
	}

	public void getCloseConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
