package join.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import join.model.JoinDto;

public interface LoginService {
	public JoinDto execute(HttpServletRequest request, HttpServletResponse response );
}
