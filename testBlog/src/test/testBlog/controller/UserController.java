package test.testBlog.controller;

import test.testBlog.dto.UserDTO;
import test.testBlog.service.UserService;

public class UserController {

	private UserService userService;

	public UserController() {
		userService = new UserService();
	}

	// 회원 정보 조회 기능
	public UserDTO select(int id) {
		UserDTO dto = userService.select(id);

		return dto;
	}
	
	// 회원 정보 삭제 기능
	public int delete(int id) {
		int userDelete = userService.delete(id);

		return userDelete;
	}
	
	// 회원 가입 기능
	public String insert(UserDTO dto, String host) {
		String response = "외부에서는 회원가입이 안됩니다.";
		
		if(host.equals("localhost")) {
			response = userService.insert(dto);
		}
		return response;
	}

}
