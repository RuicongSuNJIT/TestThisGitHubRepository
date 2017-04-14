package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import bean.Moment;
import bean.User;
import moment.MomentControl;

/**
 * Servlet implementation class ShowMoment
 */
@WebServlet("/showMoment")
public class ShowMoment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMoment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONArray arr = new JSONArray();
		User user = (User) req.getSession().getAttribute("user");
		String userId = user.getId();
		int page = Integer.parseInt(req.getParameter("page"));
		ArrayList<Moment> moments = MomentControl.getMomentsByUserId(userId, page);
		for (Moment m : moments) {
			JSONObject obj = new JSONObject();
			obj.put("text", m.getText());
			obj.put("files", m.getFiles());
			arr.put(obj);
		}

		PrintWriter pw = resp.getWriter();
		pw.println(arr);
	}
}
