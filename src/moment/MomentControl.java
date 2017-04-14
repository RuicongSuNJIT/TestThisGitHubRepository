package moment;

import java.util.ArrayList;

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

}
