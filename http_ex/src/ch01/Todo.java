
package ch01;

import java.util.LinkedHashMap;
import java.util.Map;

public class Todo {

	private int id;
	private String name;
	private String username;
	private String email;
	private String phone;
	private String website;
	private int userId;
	private String title;
	private String isCompleted;
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", username=" + username + ", userId=" + userId + ", title="
				+ title + ", isCompleted=" + isCompleted + ", email=" + email + ", phone=" + phone + ", website="
				+ website + ", additionalProperties=" + additionalProperties + ", getUserId()=" + getUserId()
				+ ", getTitle()=" + getTitle() + ", getIsCompleted()=" + getIsCompleted()
				+ ", getAdditionalProperties()=" + getAdditionalProperties() + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getUsername()=" + getUsername() + ", getEmail()=" + getEmail() + ", getPhone()="
				+ getPhone() + ", getWebsite()=" + getWebsite() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
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

	public String getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(String isCompleted) {
		this.isCompleted = isCompleted;
	}

	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

}
