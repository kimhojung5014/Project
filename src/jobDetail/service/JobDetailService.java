package jobDetail.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobDetail.model.JobDetailDto;


public interface JobDetailService {
	public JobDetailDto execute(HttpServletRequest request, HttpServletResponse response);
}
