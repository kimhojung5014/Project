package comment.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.model.CommentDto;

public interface CommentListService {
	public ArrayList<CommentDto> execute(HttpServletRequest request, HttpServletResponse response);
}
