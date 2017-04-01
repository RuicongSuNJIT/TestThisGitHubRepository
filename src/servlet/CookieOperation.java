package servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import bean.User;
import user.UserControl;

public class CookieOperation {
	public static User check(HttpServletRequest req){
		Cookie[] cookies=req.getCookies();
		String username=null;
		String password=null;
		if(cookies==null){
			return null;
		}
		for(Cookie c:cookies){
			if(c.getName().equals("name")){
				username=c.getValue();
			}
			if(c.getName().equals("pass")){
				password=c.getValue();
			}
		}
		return UserControl.login(username, password);
		
	}

}
