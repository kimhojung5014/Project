package join.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import join.model.JoinDao;
import join.model.JoinDto;

public class LoginServiceImpl implements LoginService{
	JoinDao joinDao;
	
	public LoginServiceImpl() {
		joinDao = JoinDao.getInstance();
	}
	
	@Override
	public JoinDto execute(HttpServletRequest request, HttpServletResponse response) {
	return	joinDao.login((String)request.getAttribute("userId"), (String)request.getAttribute("pw"));
		
	}
}
