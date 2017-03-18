package user;

import java.util.Map;

import bean.SessionBean;

public class UserControl {
	public static boolean login(String username, String password) {
		return UserModel.login(username, password);
	}
	
	public static boolean register(String username, String password, String email,String nickname){
		return UserModel.register(username, password, email,nickname);
	}

	public static SessionBean getSessionBean(String username) {
		Map<String,String> map=UserModel.getSessionBean(username);
		String nickname=map.get("nickname");
		String avatar=map.get("avatar");
		SessionBean user=new SessionBean(username,nickname,avatar);
		return user;
		
	}
}
