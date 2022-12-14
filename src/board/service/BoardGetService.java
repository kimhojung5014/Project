package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDto;

public interface BoardGetService {
	public BoardDto execute(HttpServletRequest request, HttpServletResponse response);

}
