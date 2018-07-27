package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.AttachmentVO;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.CommentsVO;
import kr.or.ddit.board.model.ContentVO;

public class BoardService implements BoardServiceInf {
	private BoardDaoInf bdDao = new BoardDao();

	@Override
	public List<BoardVO> allBoard() {
		return bdDao.allBoard();
	}

	@Override
	public int newBoard(BoardVO bd) {
		return bdDao.newBoard(bd);
	}

	@Override
	public int updateBoard(BoardVO bd) {
		return bdDao.updateBoard(bd);
	}

	@Override
	public BoardVO searchBoard(String name) {
		return bdDao.searchBoard(name);
	}

	@Override
	public BoardVO searchBoardNum(int num) {
		return bdDao.searchBoardNum(num);
	}

	@Override
	public Map<String, Object> showContents(Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<ContentVO> contents = bdDao.showContents(map);
		resultMap.put("contentList", contents);
		
		int total = contents.size();
		resultMap.put("total", total);
		
		int page = (int) map.get("page");
		int pageSize = (int) map.get("pageSize");
		int board_num = (int) map.get("board_num");
		
		resultMap.put("pagination", pagination(page,pageSize,total,board_num));
		
		
		return resultMap;
	}
	
	private String pagination(int page, int pageSize, int total, int board_num){
		int cnt = total / pageSize;
		int mod = total % pageSize;
		
		if(mod > 0){
			cnt++;
		}
		StringBuffer paginationStr = new StringBuffer();
		
		int prev = page == 1 ? 1 : page - 1;
		int next = cnt;	
		paginationStr.append("<li><a href=\"/boardList?page="+prev+"&pageSize="+pageSize+"&boardNum="+board_num+"\" class=\"prev fa fa-arrow-left\"> </a></li>");
		for(int i = 1 ; i < cnt+1; i++){
			String active = "";
			if(i ==page){
				active = "class=\"active\"";
				paginationStr.append("<li "+ active + "><a href=\"/boardList?page="+i+"&pageSize="+pageSize+"&boardNum="+board_num+"\">"+i+"</a></li>");
			}else{
				paginationStr.append("<li><a href=\"/boardList?page="+i+"&pageSize="+pageSize+"&boardNum="+board_num+"\">"+i+"</a></li>");
			}
			next = cnt;
		}
		paginationStr.append("<li><a href=\"/boardList?page="+next+"&pageSize="+pageSize+"&boardNum="+board_num+"\" class=\"next fa fa-arrow-right\"> </a></li>");
		return paginationStr.toString();
	}

	@Override
	public List<ContentVO> contentList(Map<String, Object> map) {
		return bdDao.showContents(map);
	}

	@Override
	public ContentVO getContent(int cont_num) {
		return bdDao.getContent(cont_num);
	}

	@Override
	public int addComments(CommentsVO comment) {
		return bdDao.addComments(comment);
	}

	@Override
	public List<CommentsVO> getComments(int cont_num) {
		return bdDao.getComments(cont_num);
	}

	@Override
	public int updateContent(ContentVO cont) {
		return bdDao.updateContent(cont);
	}

	@Override
	public CommentsVO getCom(int com_num) {
		return bdDao.getCom(com_num);
	}

	@Override
	public int updateCom(CommentsVO comment) {
		return bdDao.updateCom(comment);
	}

	@Override
	public int newContent(ContentVO content) {
		return bdDao.newContent(content);
	}

	@Override
	public int newAnswerContent(ContentVO content) {
		return bdDao.newAnswerContent(content);
	}

	@Override
	public ContentVO getContentname(String cont_title) {
		return bdDao.getContentname(cont_title);
	}

	@Override
	public int addAttachment(AttachmentVO att) {
		return bdDao.addAttachment(att);
	}

	@Override
	public List<AttachmentVO> getAttachList(int cont_num) {
		return bdDao.getAttachList(cont_num);
	}	
	

}
