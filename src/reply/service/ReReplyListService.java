package reply.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.model.ReplyDto;

public interface ReReplyListService {
	public ArrayList<ReplyDto> execute(HttpServletRequest request, HttpServletResponse response);

}
