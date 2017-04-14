package moment;

import java.util.ArrayList;

import bean.Moment;

public class MomentControl {

	public static boolean addMoment(String userId, String text, ArrayList<String> filePaths) {
		int commentNo = MomentModel.addComment(text, userId);
		if (commentNo == -1) {
			return false;
		}
		for (String filePath : filePaths) {
			if (!MomentModel.addFile(commentNo, filePath)) {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<Moment> getMomentsByUserId(String userId,int page) {
		return MomentModel.getMomentsByUserId(Integer.parseInt(userId),page);
	}

}
