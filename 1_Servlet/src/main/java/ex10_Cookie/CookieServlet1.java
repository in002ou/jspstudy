package ex10_Cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet1")
public class CookieServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 	Cookie
		 	1. 서버가 만들어서 클라이언트가 저장한다.
		 	2. 보안애 취약하다.
		 */
		// 쿠키 만들기
		Cookie ck1 = new Cookie("name", "네임");
		Cookie ck2 = new Cookie("adress", URLEncoder.encode("a dress", "UTF-8"));	// 유효하지 않은 문자(대표적으로 공백)는 UTF-8로 인코딩해서 만든다.
		Cookie ck3 = new Cookie("job", URLEncoder.encode("일", "UTF-8"));
		
		// 쿠키가 저장될 경로 설정 (생략하면 컨텍스트 패스에 저장된다.)
		ck1.setPath("/01_Servlet");					// 컨텍스트 패스 : request.getContextPath()
		ck2.setPath("/01_Servlet/CookieServlet1");	// 전체 경로(서블릿 경로) : request.getRequestURI()
													// ck3은 생략했으므로 컨텍스트 패스에 저장된다.
		
		// 쿠키 유효시간 설정 (생략하면 세션쿠키가 된다. : 브라우저를 닫을 때 까지 보관한다.)
		ck1.setMaxAge(60 * 60 * 24 * 7);		// 7일간 보관되는 쿠키
		ck2.setMaxAge(60 * 60);					// 1시간동안 보관되는 쿠키
												// ck3은 생략 했으므로 세션쿠키가 된다.
		
		// 쿠키 저장(클라이언트로 보내야 하기에 응답으로 처리해야 한다.)
		response.addCookie(ck1);
		response.addCookie(ck2);
		response.addCookie(ck3);
		// CookieServlet2으로 redirect 이동
		response.sendRedirect("/01_Servlet/CookieServlet2");
		// 쿠키 경로와 이름을 똑같이 저장하면 덮어씌우기가 된다. 따라서 쿠키를 지우고자 한다면 같은 쿠키에 유효시간을 0으로 주고 덮어씌운다.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
