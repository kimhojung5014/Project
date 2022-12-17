package board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDto;

public interface BoardSearchSearvice {
	public ArrayList<BoardDto> execute(HttpServletRequest request, HttpServletResponse response);

}
