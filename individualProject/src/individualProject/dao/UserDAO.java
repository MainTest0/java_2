package individualProject.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import individualProject.UserDTO;
import individualProject.util.DBHelper;

public class UserDAO implements IUserDAO{

	private DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}
	
	@Override
	public UserDTO select(String id) {
		
		String query = "SELECT * FROM user WHERE id = ?";
		UserDTO dto = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getInt("id"));
				dto.setUserId(rs.getInt("userId"));
				dto.setTitle(rs.getString("title"));
				dto.setBody(rs.getString("body"));
			}
		} catch (SQLException e) {
			System.out.println("UserDAO:select에서 오류발생");
			e.printStackTrace();
		}
		
		return dto;
	}

	// insert String 값으로 해야하는데 rs가 int를 반환해서 에러 남
	// 해야하는거 -> 값 추가버튼 누르면 파싱한 값이 db로 들어가게 하기
	// 프라이머리 키때문에 오류날건데 테이블 하나 더만들어서 부모자식 테이블로 오류 안뜨게하기
	// 콘솔창에 뜨는 파싱값 검색창으로 나오게 하기
	@Override
	public String insert(String userId, String id, String title, String body) {
		
		int result;
		
		String query = " INSERT INTO user(userId, id, title, body) "
				+ " VALUES(?, ?, ?, ?) ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, id);
			pstmt.setString(3, title);
			pstmt.setString(4, body);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("UserDAO:insert 에서 오류 발생");
			e.printStackTrace();
		}
		
		return result;
	}

}
