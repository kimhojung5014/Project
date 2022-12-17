package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;

public class BoardDeleteServiceImpl implements BoardDeleteService{
	BoardDao boardDao;
	public BoardDeleteServiceImpl() {
		boardDao = BoardDao.getInstance();
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		boardDao.boardDelete((int)request.getAttribute("writeNum"));
	}
}
