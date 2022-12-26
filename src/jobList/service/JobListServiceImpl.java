package jobList.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobList.model.JobDao;
import jobList.model.JobListDto;

public class JobListServiceImpl implements JobListService{
	JobDao jobDao;
	public JobListServiceImpl() {
		jobDao = JobDao.getInstance();
	}
	
	@Override
	public ArrayList<JobListDto> execute(HttpServletRequest request, HttpServletResponse response) {
		return jobDao.getJobList();
	}

}
