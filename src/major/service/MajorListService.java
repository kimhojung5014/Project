package major.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import major.model.MajorDto;

public interface MajorListService {
	public ArrayList<MajorDto>execute(HttpServletRequest request, HttpServletResponse response);
}
