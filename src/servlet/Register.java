package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module.DoUpdate;

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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("name");
		String password=request.getParameter("password");
//		String rePassword=request.getParameter("")
		String email=request.getParameter("email");
		if(DoUpdate.addUsers(username, password, email)!=0)
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		else
			request.getRequestDispatcher("/register.jsp").forward(request, response);
}
}