package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardDto;

public class BoardEditInsertServiceImpl implements BoardEditInsertService{
	BoardDao boardDao;
	public BoardEditInsertServiceImpl() {
		boardDao = BoardDao.getInstance();
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		boardDao.boardEdit((BoardDto)request.getAttribute("boardDto"));
	}

}
