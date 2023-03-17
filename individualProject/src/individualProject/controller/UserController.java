package individualProject.controller;

import individualProject.UserDTO;
import individualProject.service.UserService;

public class UserController {
	
	private UserService userService = new UserService();
	
	public UserDTO selectController(String id) {
		
		UserDTO dto = userService.selectId(id);
		
		return dto;
	}
	
	public UserDTO insertController(String id) {
		UserDTO dto = userService.selectId(id);
		
		return dto;
	}
	
	

}
