package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import bean.User;
import core.Status;
import user.UserControl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int cookieMaxAge=60*60;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		JSONObject obj = new JSONObject();
		String username = request.getParameter("name");
		String password = request.getParameter("pass");
		User user;

				
		if ((user = UserControl.login(username, password)) != null) {
			//add cookie
			Cookie cname=new Cookie("name", username);
			Cookie cpass=new Cookie("pass",password);
			cname.setMaxAge(cookieMaxAge);
			cpass.setMaxAge(cookieMaxAge);
			response.addCookie(cname);
			response.addCookie(cpass);
			
			// get session instance
			HttpSession session = request.getSession();
			user.setFilePath(new HashMap<String, String>());
			session.setAttribute("user", user);
			obj.put("status",Status.SUCCESS);
		} else {
			obj.put("status", Status.FAIL);
		}
		pw.println(obj);
		
	}
}
