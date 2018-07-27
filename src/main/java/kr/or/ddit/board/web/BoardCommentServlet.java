package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.CommentsVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.student.model.StudentVO;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

@WebServlet("/boardComment")
public class BoardCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = request.getParameter("btn");
		StudentVO user = (StudentVO) request.getSession().getAttribute("user");
		StudentServiceInf stdService = new StudentService();
		BoardServiceInf service = new BoardService();
		
		
			if(btn.equals("newComment")){
				int cont_num = Integer.parseInt(request.getParameter("cont_num"));
				
				CommentsVO newComm = new CommentsVO();
				newComm.setStd_id(user.getStd_id());
				newComm.setCom_del("N");
				newComm.setCont_num(cont_num);
				newComm.setCom_detail(request.getParameter("com_detail"));
				
				int result = service.addComments(newComm);
			}
			
			if(btn.equals("delete")){
				int com_num = Integer.parseInt(request.getParameter("com_num"));
				CommentsVO comment = service.getCom(com_num);
				comment.setCom_del("Y");
				int delete = service.updateCom(comment);
//				request.getRequestDispatcher("/boardDetail?cont_num="+comment.getCont_num());
				
			}
			
			request.getRequestDispatcher("/boardDetail").forward(request, response);
			
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
