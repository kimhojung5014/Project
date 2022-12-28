package major.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import major.model.MajorDao;
import major.model.MajorDto;

public class MajorDetailServiceImpl implements MajorDetailService{
	
		MajorDao majorDao;
		
	public MajorDetailServiceImpl() {
		majorDao = MajorDao.getInstance();
	}
	@Override
	public MajorDto execute(HttpServletRequest request, HttpServletResponse response) {
	return majorDao.majordetail((String)request.getAttribute("major"));
	}

}
