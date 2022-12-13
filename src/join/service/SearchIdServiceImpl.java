package join.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import join.model.JoinDao;

public class SearchIdServiceImpl implements SearchIdService{
	JoinDao joinDao;
	
	public SearchIdServiceImpl() {
		joinDao = JoinDao.getInstance();
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return joinDao.searchId((String)request.getAttribute("userName"), (String)request.getAttribute("data"));
		
	}
}
