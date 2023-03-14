package com.tenco.myblog.controller;

import com.tenco.myblog.DTO.BlogDTO;
import com.tenco.myblog.Service.BlogService;

public class BlogController {
	private BlogService blogService;
	
	public BlogController() {
		blogService = new BlogService();
	}
	
	// 외부에서 오는 요청을 담당하는 녀석
	public BlogDTO requestBoardContentById(int id) {
		// 메인에서 호출할거임
		BlogDTO responseDTO = blogService.selectByBoardId(id);
		
		return responseDTO;
	}
	
	// 하나의 게시글 삭제하기
	public int requestDeleteBoardById(int id, int userId) {
		int responseRow = blogService.deleteBoardById(id, userId);
		
		
		return responseRow;
	}
}
