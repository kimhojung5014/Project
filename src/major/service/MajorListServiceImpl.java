package major.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import major.model.MajorDao;
import major.model.MajorDto;

public class MajorListServiceImpl implements MajorListService{
		MajorDao majorDao;
	public MajorListServiceImpl() {
		majorDao = MajorDao.getInstance();
	}
	
	@Override
	public ArrayList<MajorDto> execute(HttpServletRequest request, HttpServletResponse response) {
	return majorDao.majorList();
	}
}
