package test.testBlog;

import test.testBlog.controller.UserController;
import test.testBlog.dao.UserDAO;
import test.testBlog.dto.UserDTO;

public class MainTest {

	public static void main(String[] args) {
		
		UserController userController = new UserController();
		
		// customer 테이블 id 값이 1인 사람 조회
		
//		UserDTO dto = userController.select(1);
//		System.out.println(dto);
		
		// customer 테이블 id 값이 1인 사람 삭제
		
//		UserDAO dao = new UserDAO();
//		dao.delete(1);
		
		// customer 테이블 회원가입하기
		UserDTO dto = new UserDTO("박정팔", "1597", "jung8@naver.com"
				, "부산");
		UserController controller = new UserController();
		String result = controller.insert(dto, "localhost");
		System.out.println(result);
		
		
		
		
	}

}
