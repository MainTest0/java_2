package individualProject.dao;

import individualProject.UserDTO;

public interface IUserDAO {
	UserDTO select(String id);
	String insert(String userId, String id, String title, String body);
}
