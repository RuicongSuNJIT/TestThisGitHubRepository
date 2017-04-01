package servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import bean.User;
import user.UserControl;

public class CookieOperation {
	public static User check(HttpServletRequest req){
		Cookie[] cookies=req.getCookies();
		String id=null;
		User user=null;
		if(cookies==null){
			return null;
		}
		for(Cookie c:cookies){
			if(c.getName().equals("id")){
				id=c.getValue();
			}
		}
		if(id!=null){
			user=UserControl.getUserById(id);
		}
		return user;
		
	}

}
