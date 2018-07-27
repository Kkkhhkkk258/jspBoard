package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;

import kr.or.ddit.board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardAdmin
 */
@WebServlet("/boardAdmin")
public class BoardAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<BoardVO> boardList = (List<BoardVO>) request.getServletContext().getAttribute("boardList");
		List<BoardVO> allBoardList = new ArrayList<BoardVO>();    //left에 보여줄거
		List<BoardVO> boardAdminList = new ArrayList<BoardVO>();  //관리할거
		BoardServiceInf bdService = new BoardService();
		String btn = request.getParameter("btn");
		
		if(btn.equals("new")){
			String newBoardName = request.getParameter("newBoard");
			String newUse = request.getParameter("newB");
			BoardVO board = new BoardVO();
			int result = 0;
			
			board.setBoard_name(newBoardName);
			board.setBoard_use(newUse);
			result = bdService.newBoard(board);
			System.out.println("new : "+result);
			
			if(result > 0){
				allBoardList = bdService.allBoard();
				System.out.println(allBoardList);
				boardAdminList = bdService.allBoard();
				System.out.println(boardAdminList);
				if(newUse.equals("Y")){
					
					allBoardList.add(board);
					request.getServletContext().setAttribute("boardList", allBoardList);
					request.getServletContext().setAttribute("boardAdminList", allBoardList);
				}else{
					boardAdminList.add(board);
					request.getServletContext().setAttribute("boardAdminList", boardAdminList);
				}
				
			}
		}else{
			int boardNum = Integer.parseInt(request.getParameter("btn"));
			String upBoardName = request.getParameter("boardName");
			String upUse = request.getParameter("updB");
			
			BoardVO upB = bdService.searchBoardNum(boardNum);
			System.out.println(upBoardName);
			System.out.println(upB);
			
			upB.setBoard_name(upBoardName);
			upB.setBoard_use(upUse);
			
			int result = bdService.updateBoard(upB);
			
			if(result > 0){
				allBoardList = bdService.allBoard();
				boardAdminList = bdService.allBoard();
				if(upUse.equals("N")){
//					allBoardList.remove();
//					System.out.println(allBoardList.contains(upBoardName));
					request.getServletContext().setAttribute("boardAdminList", boardAdminList);
					request.getServletContext().setAttribute("boardList", allBoardList);
				}
				
				request.getServletContext().setAttribute("boardList", allBoardList);
				request.getServletContext().setAttribute("boardAdminList", boardAdminList);
				
			}
			
		}
		request.getRequestDispatcher("/board/boardAdmin.jsp").forward(request, response);
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			   //
	}

}
