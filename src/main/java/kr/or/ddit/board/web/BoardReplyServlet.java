package kr.or.ddit.board.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
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
import kr.or.ddit.board.model.ContentVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.file.FileUtil;
import kr.or.ddit.student.model.StudentVO;

/**
 * Servlet implementation class BoardReplyServlet
 */
@WebServlet("/boardReply")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class BoardReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceInf bdService = new BoardService();
	private ContentVO pacont = new ContentVO();
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = request.getParameter("btn");
		StudentVO user = (StudentVO) request.getSession().getAttribute("user");
		int cont_num = Integer.parseInt(request.getParameter("cont_num"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		pacont = bdService.getContent(cont_num);
		request.setAttribute("paCont", pacont);
		request.setAttribute("content", null);
		request.getRequestDispatcher("/board/boardReply.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
//		String btn = request.getParameter("btn");
		StudentVO user = (StudentVO) request.getSession().getAttribute("user");
		BoardServiceInf bdService = new BoardService();
		String title = (String) request.getParameter("title");
		String text = (String) request.getParameter("smarteditor");
			
		int cont_num = Integer.parseInt(request.getParameter("cont_num"));
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			ContentVO pacont = bdService.getContent(cont_num);
			
			ContentVO reply= new ContentVO();
			ContentVO newContent = new ContentVO();
			reply.setBoard_num(board_num);
			reply.setCont_pa(cont_num);
			reply.setStd_id(user.getStd_id());
			reply.setCont_group(pacont.getCont_group());
			reply.setCont_del("N");
			reply.setCont_detail(text);
			reply.setCont_title(title);
			
			int result = bdService.newAnswerContent(reply);
			if(result > 0){
				newContent = bdService.getContentname(title);
				System.out.println(newContent);
				request.setAttribute("content", newContent);
				request.getRequestDispatcher("/boardDetail").forward(request, response);
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
							int uploadresult  = bdService.addAttachment(attachfile);
						}
					}
				}
			}
			
			List<AttachmentVO> attachList = bdService.getAttachList(newContent.getCont_num());
			
			request.setAttribute("attachList", attachList);
			
			request.getRequestDispatcher("/boardDetail").forward(request, response);
			
		
	}

}
