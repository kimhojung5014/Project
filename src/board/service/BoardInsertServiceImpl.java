package board.service;

import board.model.BoardDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;

public class BoardInsertServiceImpl implements BoardInsertService{
	
	BoardDao boardDao;
	
	public BoardInsertServiceImpl() {
		boardDao = BoardDao.getInstance();
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		boardDao.insertList((BoardDto)request.getAttribute("boardDto"));
	}
}
