package jobDetail.service;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobDetail.model.JobDetailDto;

public interface JobRecommendService {
	public ArrayList<JobDetailDto> execute(HttpServletRequest request, HttpServletResponse response);
}
