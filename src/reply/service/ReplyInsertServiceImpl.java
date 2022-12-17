package reply.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.model.ReplyDao;
import reply.model.ReplyDto;

public class ReplyInsertServiceImpl implements ReplyInsertService{
	ReplyDao replyDao;
	public ReplyInsertServiceImpl() {
		replyDao = ReplyDao.getInstance();
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		replyDao.replyInsert((ReplyDto)request.getAttribute("replyDto"));
	}
}
