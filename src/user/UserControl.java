package user;

import java.util.Map;

import bean.User;

public class UserControl {
	public static User login(String username, String password) {
		Map<String, String> map = UserModel.login(username, password);
		if (map == null) {
			return null;
		}
		String nickname = map.get("nickname");
		String avatar = map.get("avatar");
		String id=map.get("id");
		return new User(username, nickname, avatar,id);
	}

	public static boolean register(String username, String password, String email, String nickname) {
		return UserModel.register(username, password, email, nickname);
	}
	public static User getUser(String username) {
		Map<String, String> map = UserModel.getUser(username);
		String nickname = map.get("nickname");
		String avatar = map.get("avatar");
		String id=map.get("id");
		return new User(username, nickname, avatar,id);
	}
	public static User getUserById(String id){
		int id_int=Integer.parseInt(id);
		Map<String, String> map = UserModel.getUserbyId(id_int);
		if (map == null) {
			return null;
		}
		String nickname = map.get("nickname");
		String avatar = map.get("avatar");
		String username=map.get("username");
		return new User(username, nickname, avatar,id);
	}
}
