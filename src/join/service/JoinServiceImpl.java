package join.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import join.model.JoinDao;
import join.model.JoinDto;

public class JoinServiceImpl implements JoinService{
	
	JoinDao joinDao;
	
	public JoinServiceImpl() {
		joinDao = JoinDao.getInstance();
	}
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		joinDao.insertJoin((JoinDto)request.getAttribute("joinData"));
		
	}

}
