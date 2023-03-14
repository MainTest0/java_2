package test.testBlog.service;

import test.testBlog.dao.UserDAO;
import test.testBlog.dto.UserDTO;

public class UserService {

	private UserDAO dao;

	public UserService() {
		// 메모리 영역에 추가
		dao = new UserDAO();
	}
	
	// 회원 정보 조회기능
	public UserDTO select(int id) {
		UserDTO dto = dao.select(id);

		return dto;
	}

	// 회원 정보 삭제 기능
	public int delete(int id) {
		int resultRow = 0;

		UserDTO dto = select(id);
		// 방어적 코드
		// 삭제할 사람이 없으면 실행안함
		if (dto != null) {
			int blogWriterId = dto.getId();
			if (blogWriterId == id) {
				resultRow = dao.delete(id);
			}
		}
		return resultRow;
	}
	
	// 회원가입 기능
	public String insert(UserDTO dto) {
		String msg = "";
		// 사용자가 정보를 입력하지 않고 요청하는 경우
		if(dto.getUserName().equals(msg)) {
			System.out.println("값을 입력해주세요");
			return msg;
		}
		// UserRole은 사용자가 몰라도되니까 미리 정해주기
		dto.setUserRole("USER");
		int resultRow = dao.insert(dto);
		// 자동 형변환 int 값 resultRow에 + ""
		return resultRow+"";
	}

}
