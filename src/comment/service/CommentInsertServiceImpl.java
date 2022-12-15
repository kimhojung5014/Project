package comment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.model.CommentDao;

public class CommentInsertServiceImpl implements CommentInsertService{
	
	CommentDao commentDao;
	
	public CommentInsertServiceImpl() {
		commentDao = CommentDao.getInsetance();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		commentDao.commentInsert((int)request.getAttribute("writeNum"),
								(String)request.getAttribute("commentContent"),
								(String)request.getAttribute("userId"),
								(String)request.getAttribute("nickName"));
	}
}
