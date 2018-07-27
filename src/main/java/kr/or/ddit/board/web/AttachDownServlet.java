package kr.or.ddit.board.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.file.FileUtil;


@WebServlet("/attachDown")
public class AttachDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Disposition", "attachment; filename=\""+request.getParameter("attach") +"\"");
		response.setContentType("application/octet-stream");
		
		//FileUtil.fileUploadPath : sally.png
		//파라미터로 파일명 제공
		// localhost:8180/fileDownload?fileName=sally.png
		String fileName = request.getParameter("fileName");
		String file = FileUtil.fileUploadPath + File.separator +fileName;
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
