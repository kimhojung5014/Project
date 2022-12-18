package reply.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.model.ReplyDao;
import reply.model.ReplyDto;

public class ReplyListServiceImpl implements ReplyListService{
	ReplyDao replyDao;
	public ReplyListServiceImpl() {
		replyDao = ReplyDao.getInstance();
	}
	@Override
	public ArrayList<ReplyDto> execute(HttpServletRequest request, HttpServletResponse response) {
		
		return replyDao.replyList((int)request.getSession().getAttribute("writeNum"));
	}
}
