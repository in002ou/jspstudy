package com.gdu.ex.service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.ex.common.ActionForward;
import com.gdu.ex.domain.ExDto;
import com.gdu.ex.repository.ExDao;

public class ExDetailService implements ExService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		Optional<String> opt = Optional.ofNullable(request.getParameter("exNo"));
		int exNo = Integer.parseInt(opt.orElse("0"));
		
		ExDto ex = ExDao.getInstance().detail(exNo);
		if(ex == null) {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('존재하지 않는 EX입니다.')");
				out.println("history.back()");
				out.println("</script>");
				out.flush();
				out.close();
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("ex", ex);
		return new ActionForward("ex/detail.jsp", false);
	}

}
