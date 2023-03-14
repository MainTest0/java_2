package com.tenco.myblog2.service;

import com.tenco.myblog2.dao.UserDAO;
import com.tenco.myblog2.dto.UserDTO;

public class UserService {
	
	private UserDAO dao;
	
	public UserService() {
		dao = new UserDAO();
	}
	
	public UserDTO select(int userId) {
		
		return dao.select(userId);
	}
	
	

}
