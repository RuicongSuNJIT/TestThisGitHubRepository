package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.JSONArray;
import org.json.JSONObject;

import bean.User;
import core.FTP;

/**
 * Servlet implementation class test
 */
@MultipartConfig
@WebServlet("/uploadFile")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFile() {
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
		JSONArray arr = new JSONArray();
		User user = (User) request.getSession().getAttribute("user");
		Map<String, String> filePath = user.getFilePath();
		
		// Use this segment to get the files.
		Collection<Part> files = request.getParts();

		// define the upload saving path
		File SavingFolder = new File(this.getServletContext().getRealPath("/SavingFolder"));
		// if the folder does not exist,make it
		if (!SavingFolder.exists()) {
			SavingFolder.mkdirs();
		}
		// traverse each part and write it into disk
		for (Part file : files) {
			// get the submitted file name
			String str = file.getSubmittedFileName();

			// get the extensive name of upload files
			String ext = str.substring(str.lastIndexOf("."), str.length());

			// the filename is combination of timeStamp and file type
			String filename = new SimpleDateFormat("yyyymmddhhmmss").format(new Date())
					+ Long.toString(System.currentTimeMillis()) + ext;

			// write the file into afs
			String fileURL=FTP.upload(file.getInputStream(), filename);
			// set the filename
			JSONObject aFile = new JSONObject("{\"name\": \""+filename+"\", \"url\":\""+fileURL+"\"}");
			arr.put(aFile);
			filePath.put(file.getSubmittedFileName(), filename);
		}

		user.setFilePath(filePath);
		// return an array of filename
		out.println(arr);

	}

}
