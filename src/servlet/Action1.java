package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Action1
 */
@WebServlet("/Action1")
public class Action1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Action1() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		System.out.println(name + ", " + pass);
//		if (CA.login(name, pass)) {
//			// ..
//		} else {
//			// l....
//		}
	}
}
