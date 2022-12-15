package comment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommentInsertService {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
