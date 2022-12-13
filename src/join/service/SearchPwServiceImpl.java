package join.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import join.model.JoinDao;

public class SearchPwServiceImpl implements SearchPwService{
	JoinDao joinDao;
	
	public SearchPwServiceImpl() {
		joinDao = JoinDao.getInstance();
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return joinDao.searchPw((String)request.getAttribute("userId"), (String)request.getAttribute("data"));
		
	}
}
