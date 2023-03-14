package com.tenco.myblog2;

import com.tenco.myblog2.controller.AController;
import com.tenco.myblog2.controller.UserController;
import com.tenco.myblog2.dto.UserDTO;

public class MainTest1 {

	public static void main(String[] args) {
		
		// 1. select(); 메서드 호출할거임 -> AController로 이동
		
		// main -> AC -> AS -> AD 순서대로
		// 결과 받아보기
		// String copyMsg = "[[ >> " + msg + " << ]]";
		// AC에서 AS까지 갈려면 -> AC이동
		AController ac = new AController();
		String acResult = ac.select("혼자함");
		System.out.println(acResult);
		
		UserController userController = new UserController();
		UserDTO responseDTO = userController.select(1);
		
		System.out.println(responseDTO);
		
		
		
		
		
	}

}
