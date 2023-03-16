package url_db_test;

import java.util.LinkedHashMap;
import java.util.Map;

public class UrlDTO {
	
	private int id;
	private int userId;
	private String title;
	
	@Override
	public String toString() {
		return "UrlDTO [id=" + id + ", userId=" + userId + ", title=" + title + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
