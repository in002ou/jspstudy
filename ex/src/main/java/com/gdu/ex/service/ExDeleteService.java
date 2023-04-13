package com.gdu.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.ex.common.ActionForward;
import com.gdu.ex.repository.ExDao;

public class ExDeleteService implements ExService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		int exNo = Integer.parseInt(request.getParameter("exNo"));
		
		int result = ExDao.getInstance().delete(exNo);
		
		return new ActionForward(request.getContextPath() + "/list.do", true);
	}

}
