package com.tenco.myblog;

import com.tenco.myblog.DTO.BlogDTO;
import com.tenco.myblog.controller.BlogController;

public class MainTest1 {

	public static void main(String[] args) {
		// 코드테스트
//		DBHelper dbHelper = DBHelper.getinstance();
//		dbHelper.getConnection();
//		System.out.println("main에서 주소값 찍음 : " + dbHelper);
		
		// 코드 테스트 
		BlogController blogController = new BlogController();
		BlogDTO responseDTO =  blogController.requestBoardContentById(5);	
		System.out.println(responseDTO);
		
//		BlogController blogController = new BlogController();
//		int result = blogController.requestDeleteBoardById(8, 1);
//		System.out.println(result);
	}

}
