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
import user.UserControl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			// get session instance
			HttpSession session = request.getSession();
			user.setFilePath(new HashMap<String, String>());

			session.setAttribute("user", user);
			obj.put("status", "ok");
		} else {
			obj.put("status", "error");
		}
		pw.println(obj);
	}
}
