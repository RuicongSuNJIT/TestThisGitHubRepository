package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Action
 */
@WebServlet("/Action")
public class Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Action() {
		super();
	}

	/**
	 * @see HttpServlet#servce(HttpServletRequest request, HttpServletResponse
	 *      response)123456
	 */
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		System.out.println("Content Length: " + request.getContentLength());
		System.out.println("Content Type: " + request.getContentType());
		System.out.println("Content Path: " + request.getContextPath());
		System.out.println("Local Address: " + request.getLocalAddr());
		System.out.println("Local Name: " + request.getLocalName());
		System.out.println("Local Port: " + request.getLocalPort());
		System.out.println("Locale: " + request.getLocale());
		System.out.println("Method: " + request.getMethod());
		System.out.println("Protocol: " + request.getProtocol());
		System.out.println("Parameter Map: " + request.getParameterMap());
		System.out.println("Remote Address: " + request.getRemoteAddr());
		System.out.println("Remote Host: " + request.getRemoteHost());
		System.out.println("Remote Port: " + request.getRemotePort());
		System.out.println("Remote User: " + request.getRemoteUser());
		System.out.println("Session Id: " + request.getRequestedSessionId());
		System.out.println("URI: " + request.getRequestURI());
		System.out.println("URL: " + request.getRequestURL());
		System.out.println("Scheme: " + request.getScheme());
		System.out.println("Server Name: " + request.getServerName());
		System.out.println("Server Port: " + request.getServerPort());
		System.out.println("Servlet Path: " + request.getServletPath());
		System.out.println("Servlet Context: " + request.getServletContext());
		System.out.println("Session: " + request.getSession());
		System.out.println("User Principal: " + request.getUserPrincipal());
	}
}
