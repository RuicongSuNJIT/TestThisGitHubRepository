package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import core.Status;

/**
 * Servlet implementation class CancelUpload
 */
@WebServlet("/cancelUpload")
public class CancelUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CancelUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();

		// get the name of file that will be deleted.
		String filename = request.getParameter("name");

		// Remove from session list
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<String, String> fileToPath = (Map<String, String>) session.getAttribute("fileToPath");
		fileToPath.remove(filename);

		// remove from hardware
		Path path = Paths.get(filename);
		Files.delete(path);

		System.out.println(filename + "has been deleted");

		obj.put("status", Status.SUCCESS);
		out.println(obj);
	}
}
