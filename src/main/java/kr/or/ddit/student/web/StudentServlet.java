package kr.or.ddit.student.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.student.model.StudentVO;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/studentList")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//studentService객체를 생성, 학생 전체 리스트를 조회
		//학생 전체 리스트 request객체에 속성으로 설정
		//studentList.jsp로 forward
		StudentServiceInf stdService = new StudentService();
		
		//page,pageSize 파라미터
		//page,pageSize 파라미터 값이 없을 경우 
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		int page = pageStr == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int pageSize =pageSizeStr == null ? 10 : Integer.parseInt(request.getParameter("pageSize"));
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		
//		List<StudentVO> stdList = stdService.getStudentPageList(map);
		Map<String, Object> resultMap= stdService.getStudentPageList(map);
		List<StudentVO> stdList =(List<StudentVO>) resultMap.get("pageList");
		
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		request.setAttribute("stdList", stdList);
		request.getRequestDispatcher("/student/studentList.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
