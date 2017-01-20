package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module.DoQuery;

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
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String username=request.getParameter("name");
	String password=request.getParameter("password");
	String passwordInDB=DoQuery.getPassword(username);
	if(password==passwordInDB)
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	else
		request.getRequestDispatcher("/register").forward(request, response);
}

}
