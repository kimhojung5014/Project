package join.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import join.model.JoinDto;

public interface IdCheckService {
	public boolean execute(HttpServletRequest request, HttpServletResponse response);
}
