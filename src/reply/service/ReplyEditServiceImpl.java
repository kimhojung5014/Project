package reply.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.model.ReplyDao;

public class ReplyEditServiceImpl implements ReplyEditService{
	ReplyDao replyDao;
	public ReplyEditServiceImpl() {
		replyDao = ReplyDao.getInstance();
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		replyDao.replyEdit((int)request.getAttribute("commentNum"), (String)request.getAttribute("replyContent"));
	}

}
