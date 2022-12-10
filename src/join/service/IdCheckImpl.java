package join.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import join.model.JoinDao;

public class IdCheckImpl implements IdCheckService{
	
	JoinDao joinDao;
	
	public IdCheckImpl() {
		joinDao = JoinDao.getInstance();
	}
	
	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		return joinDao.idCheck((String)request.getAttribute("userId"));
	}
}
