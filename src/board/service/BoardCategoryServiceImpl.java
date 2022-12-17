package board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardDto;

public class BoardCategoryServiceImpl implements BoardCategoryService{
	
	BoardDao boardDao;
	public BoardCategoryServiceImpl() {
		boardDao = BoardDao.getInstance();
	}
	
	@Override
	public ArrayList<BoardDto> execute(HttpServletRequest request, HttpServletResponse response) {

		return boardDao.category((String)request.getAttribute("category"));
	}
}
