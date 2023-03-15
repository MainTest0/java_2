package test.testBlog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.testBlog.dto.UserDTO;
import test.testBlog.util.DBHelper;

public class UserDAO implements IUserDAO {

	// 계속 쓸 멤버변수 정리
	private DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO() {

		// DBHelper에서 connection 객체를 가지고 오는 동작
		dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}

	@Override
	public UserDTO select(int id) {

		String query = " SELECT * FROM customer WHERE id = ?";
		UserDTO dto = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getInt("id"));
				dto.setUserName(rs.getString("userName"));
				dto.setPassword(rs.getString("password"));
				dto.setEmail(rs.getString("email"));
				dto.setAddr(rs.getString("address"));
				dto.setUserRole(rs.getString("userRole"));
				dto.setCreateDate(rs.getString("createDate"));
			}
		} catch (SQLException e) {
			System.out.println("UserDAO에서 select에러 발생");
			e.printStackTrace();
		}

		return dto;
	}

	// 사용자 정보 삭제 기능
	@Override
	public int delete(int id) {
		int resultRow = 0;

		String query = " DELETE FROM customer WHERE id = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			resultRow = pstmt.executeUpdate();
			System.out.println(resultRow);
		} catch (SQLException e) {
			System.out.println("UserDAO에서 delete에러 발생");
			e.printStackTrace();
		}

		return resultRow;
	}

	// 회원가입 기능
	@Override
	public int insert(UserDTO dto) {

		String query = "INSERT INTO customer "
				+ " (username, password, email, address,  "
				+ "	userRole, createDate) "
				+ " VALUES(?, ?, ?, ?, ?, now()) ";
		
		int resultRow = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getUserName());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getUserRole());
			resultRow = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("UserDAO insert에서 에러 발생");
			e.printStackTrace();
		}
		
		return resultRow;
	}
}
