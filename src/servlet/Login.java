package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SessionBean;
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
		
		String username = request.getParameter("name");
		String password = request.getParameter("pass");
		
		
		if (UserControl.login(username, password)) {
			// get session instance
			HttpSession session = request.getSession();
			SessionBean user=(SessionBean) session.getAttribute("user");
			if (user == null) {
				user = UserControl.getSessionBean(username);
			}
			session.setAttribute("user", user);
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}
}
