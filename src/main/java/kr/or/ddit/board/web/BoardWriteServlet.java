package kr.or.ddit.board.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.board.model.AttachmentVO;
import kr.or.ddit.board.model.CommentsVO;
import kr.or.ddit.board.model.ContentVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.file.FileUtil;
import kr.or.ddit.student.model.StudentVO;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/boardWrite")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceInf service= new BoardService();  
    private ContentVO content = new ContentVO();
    private StudentServiceInf stdService = new StudentService();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = request.getParameter("btn");
		
		
		if(btn.equals("수정")){
//			content.setCont_title(request.getParameter("title"));
//			content.setCont_detail(request.getParameter("detail"));
			int cont_num = Integer.parseInt(request.getParameter("cont_num"));
			content = service.getContent(cont_num);
			request.setAttribute("content", content);
			request.getRequestDispatcher("/board/boardWrite.jsp").forward(request, response);
		}else if(btn.equals("삭제")){
			int cont_num = Integer.parseInt(request.getParameter("cont_num"));
			content = service.getContent(cont_num);
			content.setCont_del("Y");
			int delResult = service.updateContent(content);
			request.getRequestDispatcher("/boardList?page=1&pageSize=10&boardNum="+content.getBoard_num()).forward(request, response);
			
		}else if(btn.equals("답글")){
			int cont_num = Integer.parseInt(request.getParameter("cont_num"));
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String title = (String) request.getParameter("title");
		System.out.println(title);
		String text = (String) request.getParameter("smarteditor");
		request.setAttribute("text", text);
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		ContentVO content = new ContentVO();
		ContentVO newContent = new ContentVO();
		content.setCont_title(title);
		content.setCont_detail(text);
		StudentVO std = (StudentVO) request.getSession().getAttribute("user");
		content.setStd_id(std.getStd_id());
		content.setCont_del("N");
		content.setBoard_num(board_num);
		
		
		int result = service.newContent(content);
		
		if(result >0 ){
			
			 newContent = service.getContentname(title);
			System.out.println(newContent);
			request.setAttribute("content", newContent);
		}
		
		Collection<Part> parts = request.getParts();
		
		for(Part part :parts){
			if(part.getContentType()!=null){
				
				if(part.getSize() >0){
					String contentDisposition = part.getHeader("Content-Disposition");
					String fileName = FileUtil.getFileName(contentDisposition);
					
					
					if(!fileName.equals("")){
						String path = FileUtil.fileUploadPath;
						String file = UUID.randomUUID().toString();
						part.write(path+File.separator+file);
						part.delete();
						
						AttachmentVO attachfile = new AttachmentVO();
						attachfile.setCont_num(newContent.getCont_num());
						attachfile.setAtt_name(fileName);
						attachfile.setAtt_path(path+File.separator+file);
						attachfile.setAtt_file(file);
						int uploadresult  = service.addAttachment(attachfile);
					}
				}
			}
		}
		
		List<AttachmentVO> attachList = service.getAttachList(newContent.getCont_num());
		
		request.setAttribute("attachList", attachList);
		
		request.getRequestDispatcher("/boardDetail").forward(request, response);
		
	}
	
	
	

}
