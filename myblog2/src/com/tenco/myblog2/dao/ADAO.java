package com.tenco.myblog2.dao;

public class ADAO {
	public String select(String msg) {
		
		// 2. 문자열 아름다움 추가
		String copyMsg = "[[ >> " + msg + " << ]]";
		
		return copyMsg;	//2번 main이동
	}
}
