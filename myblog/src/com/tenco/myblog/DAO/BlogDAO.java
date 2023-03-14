package com.tenco.myblog.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tenco.myblog.DTO.BlogDTO;
import com.tenco.myblog.utils.DBHelper;

public class BlogDAO implements IBlogDAO{
	
	private Connection conn;		// = DBHelper.getinstance().getConnection();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BlogDAO() {
		conn = DBHelper.getinstance().getConnection();
	}

	@Override
	public void select() {
		
	}

	// 리턴을 클래스로 던지고싶다.
	// sql에서 나온 표처럼
	@Override
	public BlogDTO select(int id) {
		String query = " SELECT * FROM board WHERE id = ? ";
		BlogDTO dto = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new BlogDTO();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setReadCount(rs.getInt("readCount"));
				dto.setUserId(rs.getInt("userId"));
			}
		} catch (SQLException e) {
			System.out.println(">>> BlogDAO select(int id) 에서 에러 발생 <<<");
			e.printStackTrace();
		}
		return dto;
		
	}

	@Override
	public int delete(int boardId) {
		int resultRow = 0;
		
		String sql = " DELETE FROM board WHERE id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(">>> delete 에러 발생 <<<");
			e.printStackTrace();
		}
		
		return resultRow;
	}

}
