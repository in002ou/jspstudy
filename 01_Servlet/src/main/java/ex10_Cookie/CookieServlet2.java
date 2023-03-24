package ex10_Cookie;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet2")
public class CookieServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체 쿠키 가져오기
		Cookie[] cks = request.getCookies();
		// 전체 쿠키 확인하기
		if(cks != null) {
			for(int i = 0; i < cks.length; i++) {
				System.out.println("쿠키이름 : " + cks[i].getName() + ", 쿠키값 : " + URLDecoder.decode(cks[i].getValue(), "UTF-8"));
			}
		}
		// 쿠키 삭제하기 (Max-Age가 0인 쿠키로 덮어쓰기)
		Cookie ck1 = new Cookie("name", "");
		Cookie ck2 = new Cookie("job", "");
		ck1.setMaxAge(0);
		ck2.setMaxAge(0);
		response.addCookie(ck1);
		response.addCookie(ck2);
		// CookieServlet3으로 Redirect
		response.sendRedirect("/01_Servlet/CookieServlet3");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
