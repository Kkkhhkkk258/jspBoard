package kr.or.ddit.student.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.file.FileUtil;
import kr.or.ddit.student.model.StudentVO;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class StudentUpdateViewServlet
 */
@WebServlet("/studentUpdate")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   //학생 정보 수정 화면
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//학생 id 파라미터
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		//학생정보 조회
		StudentServiceInf stdService = new StudentService();
		StudentVO stdVO = stdService.getStudent(id);
		
		//request객체에 학생 정보를 설정
		request.setAttribute("stdVO", stdVO);
		
		// /student/studentUpdate.jsp로 위임
		request.getRequestDispatcher("/student/studentUpdate.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");

		// 파라미터 확인
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String addr1 = request.getParameter("addr1Input");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		
		Part picPart = request.getPart("pic");
		
		//학생 정보 조회(service)
		StudentServiceInf  stdService = new StudentService();
		StudentVO stdVO = stdService.getStudent(id);
		
		//파라미터로 받은 값을 VO에 설정
		stdVO.setName(name);
		stdVO.setAddr1(addr1);
		stdVO.setAddr2(addr2);
		stdVO.setZipcd(zipcd);
		
		//신규 프로필 사진 등록 시 
		if(picPart.getSize() > 0){
			//업로드 당시 파일명 (pic)
			//uuid를 통해 임의의 파일명을 한 작성(picname)
			//업로드 할 경로(FileUtil.uploadPath)
			String contentDisposition = picPart.getHeader("Content-Disposition");
			String pic = FileUtil.getFileName(contentDisposition);
			String picpath = FileUtil.fileUploadPath;
			String picname = UUID.randomUUID().toString();
			
			stdVO.setPic(pic);
			stdVO.setPicpath(picpath);
			stdVO.setPicname(picname);
			
			picPart.write(picpath + File.separator + picname);
			picPart.delete();
			
		}
		
		//학생 정보 업데이트
		stdService.studentUpdate(stdVO);
		
//		request.setAttribute("stdVO", stdVO);
		//학생 정보 상세조회 화면으로 이동
		response.sendRedirect("/studentDetail?id="+id);
		
		
	}


}
