package join.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import join.model.JoinDao;
import join.model.JoinDto;

public class editServiceImpl implements editService{
	JoinDao joindao;
	
	public editServiceImpl() {
		joindao = JoinDao.getInstance();
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		joindao.edit((int)request.getAttribute("numId"), (JoinDto)request.getAttribute("joinDto"));
	}
}
