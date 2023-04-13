package com.gdu.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.ex.common.ActionForward;
import com.gdu.ex.domain.ExDto;
import com.gdu.ex.repository.ExDao;

public class ExSaveService implements ExService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		String exContent = request.getParameter("exContent");
		
		ExDto ex = new ExDto();
		ex.setExContent(exContent);
		int result = ExDao.getInstance().save(ex);
		
		
		return new ActionForward(request.getContextPath() + "/list.do", true);
	}

}
