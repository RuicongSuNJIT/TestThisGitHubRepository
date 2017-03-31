package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import bean.User;
import core.Status;
import user.UserControl;

/**
 * Servlet implementation class Regester
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");

		PrintWriter pw = response.getWriter();
		JSONObject obj = new JSONObject();
		String username = request.getParameter("name");
		String password = request.getParameter("pass");
		// String rePassword=request.getParameter("")
		String email = request.getParameter("email");
		// new comment 2017/03/18
		String nickname = request.getParameter("nick");
		User user;
		if (UserControl.register(username, password, email, nickname)) {
			user=UserControl.login(username, password);
			if(user!=null){
				HttpSession session = request.getSession();
				user.setFilePath(new HashMap<String, String>());
				session.setAttribute("user", user);
			}
			else {
				obj.put("status", Status.ERROR);
			}
			obj.put("status", Status.SUCCESS);
		} else {
			obj.put("status", Status.FAIL);
		}
		pw.println(obj);
		
	}
}