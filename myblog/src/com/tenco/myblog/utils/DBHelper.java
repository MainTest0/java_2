package com.tenco.myblog.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * my sql 
 * Connection 객체를 생성하고 반환하는 자리
 */

public class DBHelper {
	
	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DATABASE_NAME = "myblog";
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_USER_NAME = "bloguser";
	private static final String DB_PASSWORD = "1q2w3e4r5t";
	
	private Connection conn;
	// 싱글톤 패턴
	// 어디서든 당기더라도 1번 DBHelper만 나타남
	
	// 기본 생성자를 만들어서 piprivate으로 설정
	private DBHelper() {
		
	}
	// 자기 자신을 private으로 선언
	private static DBHelper dbHelper;
	
	public static DBHelper getinstance() {
		if(dbHelper == null) {
			dbHelper = new DBHelper();
		}
		return dbHelper;
	}
	
	public Connection getConnection() {
		if(conn == null) {
			// 한번도 생성하지 않았다면 동작
			String urlFormat = "jdbc:mysql://%s:%s/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST, DB_PORT, DATABASE_NAME, DB_CHARSET);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
				System.out.println(">> DB 연결 완료 <<");
			} catch (Exception e) {
				System.out.println(">> DBHelper 에서 오류가 발생 했어! <<");
				e.printStackTrace();
			}
		}
		// todo 추후 삭제 예정
		// System.out.println("DBHelper 안에서 주소 찍어보기 : " + this);
		return conn;
	}
	
	
	public void closeconnection() {
		try {
			conn.close();
			// conn의 주소값 날리기
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
