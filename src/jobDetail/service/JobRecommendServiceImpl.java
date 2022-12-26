package jobDetail.service;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobDetail.model.JobDetailDto;
import jobList.model.JobDao;

public class JobRecommendServiceImpl implements JobRecommendService{
	
	JobDao jobDao;
	
	public JobRecommendServiceImpl() {
		jobDao = JobDao.getInstance();
	}
	
	@Override
	public ArrayList<JobDetailDto> execute(HttpServletRequest request, HttpServletResponse response) {
		
		return jobDao.jobRecommendList((String)request.getAttribute("ability"),
									   (String)request.getAttribute("kindOfJob"),
									   (String)request.getAttribute("possibility"));
	}
}
