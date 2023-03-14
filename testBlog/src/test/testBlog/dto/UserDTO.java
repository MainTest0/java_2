package test.testBlog.dto;

public class UserDTO {
	
	int id;
	String userName;
	String password;
	String email;
	String addr;
	String userRole;
	String createDate;
	
	public UserDTO() {

	}
	
	public UserDTO(String userName, String password, String email, String addr) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.addr = addr;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", addr=" + addr + ", userRole=" + userRole + ", createDate=" + createDate + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
