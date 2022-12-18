package reply.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.model.ReplyDao;

public class ReplyDeleteServiceImpl implements ReplyDeleteService{
	
	ReplyDao replyDao;
	
	public ReplyDeleteServiceImpl() {
		replyDao = ReplyDao.getInstance();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		replyDao.replyDelete((int)request.getAttribute("commentNum"));
	}
}
