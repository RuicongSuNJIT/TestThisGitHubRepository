package core;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.jcraft.jsch.JSchException;

public class FTPPool {
	private static List<FTP> used = new LinkedList<>();
	private static Stack<FTP> pool = new Stack<>();

	public static synchronized FTP getFTP() {
		FTP ftp;
		if (pool.isEmpty()) {
			try {
				ftp = new FTP();
				used.add(ftp);
				return ftp;
			} catch (JSchException e) {
				e.printStackTrace();
				return null;
			}
		}
		ftp = pool.pop();
		used.add(ftp);
		return ftp;
	}

	static synchronized void free(FTP ftp) {
		used.remove(ftp);
		pool.add(ftp);
	}
	
	public static int length(){
		return pool.size();
	}
}
