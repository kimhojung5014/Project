package major.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import major.model.MajorDto;

public interface MajorDetailService {
	public MajorDto execute(HttpServletRequest request, HttpServletResponse response);
}
