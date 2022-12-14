package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardDto;

public class BoardGetServiceImpl implements BoardGetService{
	
	BoardDao boardDao;

	public BoardGetServiceImpl() {
		boardDao = BoardDao.getInstance();
	}
	
	@Override
	public BoardDto execute(HttpServletRequest request, HttpServletResponse response) {
		
		return boardDao.getBoard((int)request.getAttribute("writeNum"));
	}
	
	

}
