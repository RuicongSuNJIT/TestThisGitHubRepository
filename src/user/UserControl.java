package user;

import java.util.Map;

import bean.User;

public class UserControl {
	public static boolean login(String username, String password) {
		return UserModel.login(username, password);
	}

	public static boolean register(String username, String password, String email, String nickname) {
		return UserModel.register(username, password, email, nickname);
	}

	public static User getUser(String username) {
		Map<String, String> map = UserModel.getUser(username);
		String nickname = map.get("nickname");
		String avatar = map.get("avatar");
		User user = new User(username, nickname, avatar);
		return user;

	}
}
