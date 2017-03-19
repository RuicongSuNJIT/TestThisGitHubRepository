package servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Test
 */
@WebFilter(filterName = "authorityFilter", urlPatterns = { "/*" })
public class AuthorityFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AuthorityFilter() {
		// TODO Auto-generated constructor stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// initial settings
		response.setContentType("application/json;charset=utf-8");
		final String loginPage = "/login";
		final String registerPage = "/register";

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(true);
		// get the page which the user request for
		String requestPath = req.getServletPath();
		// if the user did not login and request path is neither login nor
		// register,dispatch to login page
		if (!(session.getAttribute("user") == null) && !requestPath.endsWith(loginPage)
				&& !requestPath.endsWith(registerPage)) {
			request.getRequestDispatcher(loginPage).forward(request, response);
		}
		// let it go
		else {
			chain.doFilter(request, response);
		}

	}

}
