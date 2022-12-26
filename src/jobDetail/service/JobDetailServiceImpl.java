package jobDetail.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobDetail.model.JobDetailDao;
import jobDetail.model.JobDetailDto;

public class JobDetailServiceImpl implements JobDetailService{
	
	JobDetailDao jobDetailDao;
	
	public JobDetailServiceImpl() {
		jobDetailDao = JobDetailDao.getInstance();
	}
	
	@Override
	public JobDetailDto execute(HttpServletRequest request, HttpServletResponse response) {
		return jobDetailDao.getJobdetailData((String)request.getAttribute("job"));
		
	}

}
