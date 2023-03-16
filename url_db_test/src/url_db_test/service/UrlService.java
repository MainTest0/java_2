package url_db_test.service;

import url_db_test.dao.UrlDAO;

public class UrlService {
	
	UrlDAO dao;
	
	public UrlService() {
		dao = new UrlDAO();
	}
	
	public String save(int id, int userId, String title) {
		String result = "저장에 실패했습니다.";
		int resultRow = dao.update(id, userId, title);
		if(resultRow != 0) {
			result = "저장에 성공했습니다.";
		}
		return result;
	}

}
