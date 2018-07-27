package kr.or.ddit.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.student.model.StudentVO;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/pic")
public class PicDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// <img src="/pic?id=12/>
		int id = Integer.parseInt(request.getParameter("id"));
		
		// /물리 파일명을 이용하여 사진 다운로드 부터 진행
		
		//사용자정보 조회
		StudentServiceInf stdService = new StudentService();
		StudentVO stdVO = stdService.getStudent(id);
		
//		response.setHeader("Content-Disposition", "attachment; filename=\""+stdVO.getPic()+"\"");
		response.setContentType("application/octet-stream");
		
		//FileUtil.fileUploadPath : sally.png
		//파라미터로 파일명 제공
		// localhost:8180/fileDownload?fileName=sally.png
//		String fileName = request.getParameter("fileName");
//		String file = FileUtil.fileUploadPath + File.separator +fileName;
		String file= stdVO.getPicpath() + File.separator + stdVO.getPicname();
		
		//file 입출력을 위한 준비
		ServletOutputStream sos = response.getOutputStream();
		
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		byte[] b = new byte[512];
		int len = 0;
		while((len =fis.read(b)) != -1){
			sos.write(b, 0, len);
		}
		sos.close();
		fis.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
