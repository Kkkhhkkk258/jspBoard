package kr.or.ddit.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/fileUpload")
//bytes
//1kb = 1024
//1MB = 1kb*1000
//5MB = 1MB * 5 = 1kb *1000 * 5
@MultipartConfig(maxFileSize=1024*1000*5, maxRequestSize=1024*1000*16)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//parameter : userId, uploadFile
		//일반 텍스트 파라미터는 request.getParameter를 통해서 얻을 수 있다
		//파일의 경우  request.getPart를 통해서 얻을 수 있다
		logger.debug("contentType : " + request.getContentType());
		logger.debug("userId : "+request.getParameter("userId"));
//		logger.debug("uploadFile : "+ request.getParameter("uploadFile"));
		
		//getPart
		Part uploadFilePart = request.getPart("uploadFile");
//		logger.debug("part getName() : "+ uploadFilePart.getName());
		
		//file 이름에 대한 정보를 획득: getHeader("Content-Disposition");
		String contentDisposition = uploadFilePart.getHeader("Content-Disposition");
		logger.debug("ContentDisposition : "+contentDisposition);
		
		String fileName = FileUtil.getFileName(contentDisposition);
		logger.debug("fileName : "+ fileName);
		
		//파일 저장 경로 설정
		//실무: 별도 Storage
		//개발환경: 임의 영역 (서버 변경시, 재기동시 업로드 파일 삭제됨)
		// /fileUpload 디렉토리에 임의로 작성
		//D:\A_TeachingMaterial\7.JspSrpgin\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
		
		//url --> realpath : application 객체에서 제공해주는 메소드
		//doPost 메소드 안에서 application(servletContext) 객체를 구한다
		
		//1.request.getServletContext()
		//2.getServletContext() (서블릿에서 제공하는 메서드)
		
		
		//임의의 배포경로
		String path = FileUtil.fileUploadPath;
//		ServletContext servletContext = getServletContext();
//		String path = servletContext.getRealPath("/fileUpload");
		
		
		//filesize가 정상적인 경우에만 업로드를 수행한다
		if(uploadFilePart.getSize() > 0){
			uploadFilePart.write(path+File.separator+UUID.randomUUID().toString());
//			uploadFilePart.write(path+File.separator+fileName);
			uploadFilePart.delete();
		}
		
		
	}

}
