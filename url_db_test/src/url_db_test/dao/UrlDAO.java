package url_db_test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import url_db_test.util.DBHelper;

public class UrlDAO implements IUrlDAO {

	private DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;

	public UrlDAO() {
		dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}

	@Override
	public int update(int id, int userId, String title) {

		int resultRow = 0;

		String query = " INSERT INTO albums(userId, id, title) " 
		+ " VALUES (?, ?, ?) ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, id);
			pstmt.setString(3, title);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DAO에서 오류 발생");
			e.printStackTrace();
		}

		return resultRow;
	}

}
