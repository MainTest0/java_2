package individualProject.service;

import individualProject.dao.UserDAO;
import individualProject.UserDTO;

public class UserService {
	
	private UserDAO dao;
	UserDTO dto;
	
	public UserService() {
		dao = new UserDAO();
	}
	
	public UserDTO selectId(String id) {
		
		dto = dao.select(id);
		
		return dto;
	}
	
	public String insertId(String userId, String id, String title, String body) {
		
		dto = dao.insert(userId, id, title, body);
		
		return dto;
	}

}
