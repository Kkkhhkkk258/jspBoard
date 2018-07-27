package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.ContentVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		request.getSession().setAttribute("boardNum", boardNum);
		
		BoardServiceInf bdService = new BoardService();
		BoardVO board = bdService.searchBoardNum(boardNum);
		request.getSession().setAttribute("board", board);
		
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board_num", boardNum);
		map.put("page", page);
		map.put("pageSize", pageSize);
		
		Map<String, Object> result = bdService.showContents(map);
		List<ContentVO> contentList = (List<ContentVO>) result.get("contentList");
	
		String pagination = (String) result.get("pagination");
		
		request.setAttribute("contentList", contentList);
		request.setAttribute("paginatiion", pagination);
		System.out.println("page: "+pagination);
		System.out.println(">>>>>>"+ contentList);
				
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
	}

	

}
