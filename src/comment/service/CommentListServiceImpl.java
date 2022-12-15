package comment.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.model.CommentDao;
import comment.model.CommentDto;

public class CommentListServiceImpl implements CommentListService{
	
	CommentDao commentDao;
	
	public CommentListServiceImpl() {
		commentDao = CommentDao.getInsetance();
	}
	@Override
	public ArrayList<CommentDto> execute(HttpServletRequest request, HttpServletResponse response) {
		return commentDao.commentList((int)request.getAttribute("writeNum"));
	}
}
