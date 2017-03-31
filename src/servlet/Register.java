package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

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

		if (UserControl.register(username, password, email, nickname)) {
			obj.put("status", "注册成功");
		} else {
			obj.put("status", "用户名已存在");
		}
		pw.println(obj);
	}
}