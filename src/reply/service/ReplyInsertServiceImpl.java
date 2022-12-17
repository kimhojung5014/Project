package reply.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.model.ReplyDao;

public class ReplyInsertServiceImpl implements ReplyInsertService{
	ReplyDao replyDao;
	public ReplyInsertServiceImpl() {
		replyDao = ReplyDao.getInstance();
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		replyDao.replyInsert((int)request.getAttribute("writeNum"),
							 (int)request.getAttribute("commentNum"),
							 (String)request.getAttribute("replyContent"),
							 (String)request.getAttribute("userId"),
							 (String)request.getAttribute("nickName"));
	}
}
