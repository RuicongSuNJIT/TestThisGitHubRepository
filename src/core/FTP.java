package core;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class FTP {
	private Session session;
	private Channel channel;
	private ChannelSftp sftp;

	FTP() throws JSchException {
		JSch jsch = new JSch();
		session = jsch.getSession(Constants.FTP_USER, Constants.FTP_HOST, 22);
		session.setConfig("PreferredAuthentications", "password");
		session.setConfig("StrictHostKeyChecking", "no");
		session.setPassword(Constants.FTP_PASS);
		session.connect();
		channel = session.openChannel("sftp");
		sftp = (ChannelSftp) channel;
		sftp.connect();
	}

	public void release() {
		FTPPool.free(this);
	}

	void close() {
		sftp.quit();
		channel.disconnect();
		session.disconnect();
	}

	public String upload(InputStream file, String fileName) {
		try {
			sftp.put(file, Constants.FTP_DIR + fileName);
			return Constants.FTP_BASEPATH + fileName;
		} catch (SftpException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public StatusE remove(String fileName){
		try {
			sftp.rm(Constants.FTP_DIR + fileName);
			return StatusE.SUCCESS;
		} catch (SftpException e) {
			if(e.id == 2){
				return StatusE.NO_SUCH_FILE;
			} else {
				e.printStackTrace();
			}
			return StatusE.ERROR;
		}
	}
}
