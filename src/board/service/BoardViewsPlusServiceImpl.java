package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;

public class BoardViewsPlusServiceImpl implements BoardViewsPlusService{
	BoardDao boardDao;
	
	public BoardViewsPlusServiceImpl() {
		boardDao = BoardDao.getInstance();
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		boardDao.BoardViews((int)request.getAttribute("writeNum"), (int)request.getAttribute("views"));
		
	}

}
