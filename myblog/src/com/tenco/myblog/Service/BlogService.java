package com.tenco.myblog.Service;

import com.tenco.myblog.DAO.BlogDAO;
import com.tenco.myblog.DTO.BlogDTO;

public class BlogService {

	private BlogDAO blogDAO;

	public BlogService() {
		blogDAO = new BlogDAO();
	}

	// 하나의 게시글 찾는 로직을 만들기
	public BlogDTO selectByBoardId(int id) {
		BlogDTO resultDto = blogDAO.select(id);

		return resultDto;
	}

	public int deleteBoardById(int boardId, int userId) {
		int resultRow = 0;
		// 유저 아이디 값과
		// board 테이블에 있는 작성자의 userId 값이 같은지 확인
		BlogDTO dto = selectByBoardId(boardId);

		// 방어적코드
		// 삭제한거 또 삭제하면 NPE
		if (dto != null) {
			int blogWriterId = dto.getUserId();
			if (blogWriterId == userId) {
				resultRow = blogDAO.delete(boardId);
			}
		}
		return resultRow;
	}

}
