package test.testBlog.dao;

import test.testBlog.dto.UserDTO;

public interface IUserDAO {
	
	UserDTO select(int id);
	int delete(int id);
	int insert(UserDTO dto);

}
