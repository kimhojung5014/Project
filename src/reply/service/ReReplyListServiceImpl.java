package reply.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.model.ReplyDao;
import reply.model.ReplyDto;

public class ReReplyListServiceImpl implements ReReplyListService{
	ReplyDao replyDao;
	public ReReplyListServiceImpl() {
		replyDao = ReplyDao.getInstance();
	}
	@Override
	public ArrayList<ReplyDto> execute(HttpServletRequest request, HttpServletResponse response) {
		
		return replyDao.reReplyList((int)request.getAttribute("writeNum"));
	}
}
