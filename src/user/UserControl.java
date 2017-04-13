package user;

import java.util.ArrayList;
import java.util.HashMap;
import bean.User;

public class UserControl {

	public static User login(String username, String password) {
		User user = UserModel.login(username, password);
		if (user == null) {
			return null;
		}
		user.setFilePath(new HashMap<>());
		return user;
	}

	public static boolean register(String username, String password, String email, String nickname) {
		return UserModel.register(username, password, email, nickname);
	}

	public static User getUser(String username) {
		return UserModel.getUser(username);
	}

	public static User getUserById(String id) {
		return UserModel.getUserbyId(Integer.parseInt(id));
	}

	public static User loginById(String id) {
		User user = getUserById(id);
		if(user != null){
			user.setFilePath(new HashMap<>());
		}
		return user;
	}

	
}
