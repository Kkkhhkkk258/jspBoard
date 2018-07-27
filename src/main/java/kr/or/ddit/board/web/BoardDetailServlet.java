package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.AttachmentVO;
import kr.or.ddit.board.model.CommentsVO;
import kr.or.ddit.board.model.ContentVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.student.model.StudentVO;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/boardDetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardServiceInf service= new BoardService();  
    private ContentVO content = new ContentVO();
    private StudentServiceInf stdService = new StudentService();
    private String btn = "";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cont_num = Integer.parseInt(request.getParameter("cont_num"));
		content = service.getContent(cont_num);
		request.setAttribute("content", content);
		StudentVO std = stdService.getStudentStdId(content.getStd_id());
		btn = request.getParameter("btn");
		
		List<AttachmentVO> attachList = service.getAttachList(cont_num);
		request.setAttribute("attachList", attachList);
		
		request.setAttribute("writer", std.getName());
		StudentVO user = (StudentVO) request.getSession().getAttribute("user");
		System.out.println(user);
		
		String type = "";
		if(content.getStd_id().equals(user.getStd_id())){
			type = "submit";
		}else{
			type="hidden";
		}
		request.setAttribute("type", type);
		
		
		
		//댓글 
		List<CommentsVO> comments = service.getComments(cont_num);
		request.setAttribute("commentList", comments);
		request.getRequestDispatcher("/board/boardDetail.jsp").forward(request, response);
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ContentVO content = (ContentVO) request.getAttribute("content");
		System.out.println("여기 새글 >>>"+content);
		request.setAttribute("content", content);
		
		StudentVO user = (StudentVO) request.getSession().getAttribute("user");
		request.setAttribute("writer", user.getName());
		
		
		List<AttachmentVO> attachList = service.getAttachList(content.getCont_num());
		
		request.setAttribute("attachList", attachList);
		
		request.getRequestDispatcher("/board/boardDetail.jsp").forward(request, response);
	}

	

}
