package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDAO;

public class BoardRemoveService implements IBoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			
			if(request.getMethod().equals("get")) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('잘못된 요청입니다.')");
				out.println("history.back()");
				out.println("</script>");
				out.flush();
				out.close();
				return null;	// 컨트롤러로 null값을 반환하면 컨트롤러는 이동(redirect 또는 forward)을 하지 않는다.
								// 서비스에서 직접 이동하는 경우에 이 방법을 사용한다.
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// 1. 요청 파라미터
		String strBoard_no = request.getParameter("board_no");
		// 폼에 name 속성은 값이 없으면 빈문자열로 들어간다. 따라서 null이 아닌 공백처리를 해야한다.
		int board_no = Integer.parseInt(strBoard_no.isEmpty() ? "0" : strBoard_no);
		
		// 2. BoardDAO의 deleteBoard 메소드 호출
		int deleteResult = BoardDAO.getInstance().deleteBoard(board_no);
		
		System.out.println(deleteResult == 1 ? "삭제성공" : "삭제실패");
		
		// 삭제 하였기 때문에 리다이렉트
		return new ActionForward(request.getContextPath() + "/getAllBoards.do", true);
	}

}
