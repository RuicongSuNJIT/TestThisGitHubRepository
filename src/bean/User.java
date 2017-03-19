package bean;

import java.util.Map;

public class User {
	private String username;
	private String nickname;
	private int id;
	private String avatar;
	private Map<String,String> filePath;
	public User() {
		super();
	}
	public User(String username, String nickname,String avatar) {
		super();
		this.username = username;
		this.nickname = nickname;
		this.avatar = avatar;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Map<String, String> getFilePath() {
		return filePath;
	}
	public void setFilePath(Map<String, String> filePath) {
		this.filePath = filePath;
	}
	@Override
	public String toString() {
		return "SessionBean [username=" + username + ", nickname=" + nickname + ", id=" + id + ", avatar=" + avatar
				+ ", filePath=" + filePath + "]";
	}
	
}
