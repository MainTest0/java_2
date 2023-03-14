package com.tenco.myblog2.dao;

import com.tenco.myblog2.dto.UserDTO;

public class UserDAO {

	// 1. UserDTO를 만들어보세요
	public UserDTO select(int userId) {
		// userDTO 객체를 임의의 값을 생성하고
		// 그 결과값을 메인함수에서 출력하세요
		UserDTO kimUser = new UserDTO(1, "미스터 킴");

		return kimUser;
	}

	
	
}
