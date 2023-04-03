package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.BoardDTO;
import repository.BoardDAO;

public class BoardsService implements IBoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 1. BoardDAO 객체 준비
		BoardDAO dao = BoardDAO.getInstance();
		
		// 2. BoardDAO의 selectBoards 메소드 호출 (DB로부터 게시글 목록 가져오기)
		List<BoardDTO> boards = dao.selectBoards();
		
		// 3. DB로부터 가져온 게시글 목록 boards를 request에 저장 (forward 하기 위해서)
		request.setAttribute("boards", boards);
		
		// 4. 어디로 and 어떻게 이동
		ActionForward af = new ActionForward("board/list.jsp", false);	// board 폴더 아래 list.jsp로 forward(request 전달) 하시오.
		
		return af;
	}

}
