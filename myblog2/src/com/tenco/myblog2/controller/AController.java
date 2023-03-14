package com.tenco.myblog2.controller;

import com.tenco.myblog2.service.AService;

public class AController {
	
	private AService as;
	
	public AController() {
		as = new AService();
	}
	
	// 1. main 1번 만들기 -> AService 이동
	public String select(String msg) {

		String result1 = as.select(msg);
		
		return result1;
	}

}
