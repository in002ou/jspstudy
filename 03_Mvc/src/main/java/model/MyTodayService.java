package model;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class MyTodayService implements MyService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// System.currentTimeMillis() Date(sql)로 -으로 분리해줌 자바는 이렇게 분리 안해준다.
		request.setAttribute("today", new Date(System.currentTimeMillis()));
		// 값을 다시 controller(servlet)에 정보를 보내야 할 주소 리턴
		// 어디로 어떻게 갈 것인가?
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("view/output.jsp");
		actionForward.setRedirect(false);	// forward
		return actionForward;
	}

}
