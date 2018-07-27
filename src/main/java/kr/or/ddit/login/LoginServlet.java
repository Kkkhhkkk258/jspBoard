package kr.or.ddit.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceTest;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.student.model.StudentVO;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("form-username");
		String password = request.getParameter("password");
		
		StudentServiceInf stdService = new StudentService();
		StudentVO stdVO = stdService.getUser(userId);
		
		BoardServiceInf bdService = new BoardService();
		
		
		if(stdVO.checkSuccess(userId, password)){
			System.out.println("login Success -"+ stdVO.getName());
			
			request.getSession().setAttribute("user", stdVO);
			request.getServletContext().setAttribute("boardList", bdService.allBoard());
			request.getServletContext().setAttribute("boardAdminList", bdService.allBoard());
			request.getRequestDispatcher("/common/main.jsp").forward(request, response);
			
			
		}else{
			request.getRequestDispatcher("/login/login.jsp");
		}
	}

}
