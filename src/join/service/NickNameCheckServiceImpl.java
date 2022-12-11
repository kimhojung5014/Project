package join.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import join.model.JoinDao;
import join.model.JoinDto;

public class NickNameCheckServiceImpl implements NickNameCheckService{
	
	JoinDao joinDao;
	
	public NickNameCheckServiceImpl() {
		joinDao = JoinDao.getInstance();
	}
	
	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		return joinDao.idCheck((String)request.getAttribute("userId"));
}
}