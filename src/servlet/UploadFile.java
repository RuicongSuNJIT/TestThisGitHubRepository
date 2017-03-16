package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.json.JSONObject;

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
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();

		// get session instance
		HttpSession session = request.getSession();
		Map<String, String> fileToPath = new HashMap<>();
		session.getAttribute("fileToPath");

		// Use this segment to get the files.
		Collection<Part> files = request.getParts();

		// Use for each format to get every file. Instead output the file name,
		// I need you
		// to save the files in local position. And save the local url into
		// session. Key
		// is the file name and the value is the local path. Additionally, I
		// think you need
		// to give the file a new name based on the time stamp. For example,
		// 'Image20170315195745' means the file is start writing to local disk
		// at 19:57:45,
		// on March/15/2017. For the extra name, you need to judge whether it is
		// a jpg, gif
		// or some other type. I have limited the default kind of file to be
		// image, which
		// means that when the open file dialog pop up, it will typically should
		// only image
		// files. Although the user now can change the file filter to all files,
		// we do not
		// judge whether the file is an image or not.

		// define the upload saving path
		File SavingFolder = new File(this.getServletContext().getRealPath("/SavingFolder"));
		// if the folder does not exist,make it
		if (!SavingFolder.exists()) {
			SavingFolder.mkdirs();
		}
		// traverse each part and write it into disk
		for (Part file : files) {
			// the return of file.getContentType() will be like this:
			// "image/jpeg"
			String str = file.getSubmittedFileName();

			// get the extensive name of upload files
			String ext = str.substring(str.lastIndexOf("."), str.length());

			// the filename is combination of timeStamp and file type
			String filename = SavingFolder.toString() + File.separator
					+ new SimpleDateFormat("yyyymmddhhmmss").format(new Date())+Long.toString(System.currentTimeMillis()) + ext;

			// write the file into server disk
			file.write(filename);
			System.out.println(file.getSubmittedFileName() + "\nsaved as:" + filename);
			
			//set the fileToPath 
			fileToPath.put(file.getSubmittedFileName(), filename);
		}
		
		//set the session attributes
		session.setAttribute("fileToPath", fileToPath);


		obj.put("status", "OK");
		out.println(obj);

	}

}
