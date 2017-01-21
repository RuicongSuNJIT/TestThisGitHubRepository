package user;

public class UserControl {
	public static boolean login(String username, String password) {
		return UserModel.login(username, password);
	}
	
	public static boolean register(String username, String password, String email){
		return UserModel.register(username, password, email);
	}
}
