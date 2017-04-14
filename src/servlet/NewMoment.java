package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import bean.User;
import moment.MomentControl;
import user.UserControl;

/**
 * Servlet implementation class NewComment
 */
@WebServlet("/newMoment")
public class NewMoment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewMoment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");

		// To submit the comment, you need to load the comment content by a
		// parameter name "comment" first. Additionally, you need to add all the
		// files into database as well, which still remain in session.
		JSONObject obj=new JSONObject();
		PrintWriter out = response.getWriter();
		User user=(User) request.getSession().getAttribute("user");
		ArrayList<String> filePaths=new ArrayList<>();
		for(String value:user.getFilePath().values()){
			filePaths.add(value);
		}
		String text=request.getParameter("content");		
		if(MomentControl.addMoment(user.getId(),text,filePaths)){
			obj.put("status", "ok");
		}else{
			obj.put("status", "failed");
		}
		user.getFilePath().clear();
		out.println(obj);
	}
}
