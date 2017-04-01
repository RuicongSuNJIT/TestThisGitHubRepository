package core;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class FTP {
	public static String upload(InputStream file, String fileName) {
		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession(Constants.FTP_USER, Constants.FTP_HOST, 22);
			session.setConfig("PreferredAuthentications", "password");
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(Constants.FTP_PASS);
			session.connect();
			Channel channel = session.openChannel("sftp");
			ChannelSftp sftp = (ChannelSftp) channel;
			sftp.connect();
			sftp.put(file, Constants.FTP_DIR + fileName);
			sftp.quit();
			channel.disconnect();
			session.disconnect();
			return Constants.FTP_BASEPATH + fileName;
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SftpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
