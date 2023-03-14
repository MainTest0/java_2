package com.tenco.myblog.DAO;

import com.tenco.myblog.DTO.BlogDTO;

public interface IBlogDAO {
	
	void select();	// 전체조회
	BlogDTO select(int id);		// id 기반으로 조회
	int delete(int boardId);

}
