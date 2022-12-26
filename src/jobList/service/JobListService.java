package jobList.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobList.model.JobListDto;

public interface JobListService {
	public ArrayList<JobListDto> execute(HttpServletRequest request, HttpServletResponse response);

}
