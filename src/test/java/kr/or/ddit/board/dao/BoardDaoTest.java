package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.CommentsVO;
import kr.or.ddit.board.model.ContentVO;

import org.junit.Before;
import org.junit.Test;

public class BoardDaoTest {
	
	@Test
	public void allBoardtest() {
		/***Given***/
		BoardDaoInf boardDao = new BoardDao();
		List<BoardVO> boardList = null;

		/***When***/
		boardList = boardDao.allBoard();

		/***Then***/
		assertEquals(4, boardList.size());

	}
	
//	@Test
//	public void newBoardTest(){
//		/***Given***/
//		BoardDaoInf boardDao = new BoardDao();
//		BoardVO board = new BoardVO();
//		board.setBoard_name("Test");
//		board.setBoard_use("N");
//		int result = 0;
//		
//		/***When***/
//		result = boardDao.newBoard(board);
//
//		/***Then***/
//		assertEquals(1, result);
//	}
	
	@Test
	public void searchBoardTest(){
		/***Given***/
		BoardDaoInf dao = new BoardDao();
		String name ="FreeBoard";
		
		/***When***/
		BoardVO bd = dao.searchBoard(name);
		/***Then***/
		assertEquals(1, bd.getBoard_num());

	}
	
	@Test
	public void updateBoardTest(){
		/***Given***/
		BoardDaoInf dao = new BoardDao();
		
		BoardVO upBoard = dao.searchBoard("test");
		System.out.println(upBoard);
		upBoard.setBoard_name("test");
		upBoard.setBoard_use("Y");
		
		/***When***/
		int result = dao.updateBoard(upBoard);
		
		/***Then***/
		assertEquals(1, result);
	}
	
	@Test
	public void showContentsTest(){
		/***Given***/
		BoardDaoInf dao = new BoardDao();
		List<ContentVO> contents = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board_num", 1);
		map.put("page", 1);
		map.put("pageSize", 10);
		
		/***When***/
		contents = (List<ContentVO>) dao.showContents(map);

		/***Then***/
		assertEquals(3, contents.size());

	}
	
	@Test
	public void getContentTest(){
		/***Given***/
		int cont_num = 1;
		BoardDaoInf dao = new BoardDao();
		
		/***When***/
		ContentVO content = dao.getContent(cont_num);
		
		/***Then***/
		assertEquals(1, content.getCont_num());
	}
	
//	@Test
//	public void addCommentsTest(){
//		/***Given***/
//		
//		BoardDaoInf dao = new BoardDao();
//		CommentsVO comment = new CommentsVO();
//		comment.setCom_del("N");
//		comment.setCom_detail("댓글이다 daoTest하는중 ");
//		comment.setCont_num(1);
//		comment.setStd_id("std5");
//		
//		/***When***/
//		int result = dao.addComments(comment);
//		/***Then***/
//		assertEquals(1, result);
//	}
	@Test
	public void getCommentsTest(){
		/***Given***/
		List<CommentsVO> commList = null;
		BoardDaoInf dao = new BoardDao();
		int cont_num = 1;
		/***When***/
		commList = dao.getComments(cont_num);
		
		/***Then***/
		assertEquals(3, commList.size());
	}
	
	@Test
	public void updatdContentTest(){
		/***Given***/
		int result = 0;
		BoardDaoInf d = new BoardDao();
		ContentVO cont = d.getContent(4);
		cont.setCont_del("Y");
		cont.setCont_title("수요일까지 가능??");
		
		/***When***/
		result = d.updateContent(cont);

		/***Then***/
		assertEquals(1, result);

	}
	
//	@Test
//	public void newConentTest(){
//		/***Given***/
//		BoardDaoInf dao = new BoardDao();
//		ContentVO cont = new ContentVO();
//		cont.setCont_title("글을 쓰자");
//		cont.setCont_detail("test중입니당");
//		cont.setBoard_num(1);
//		cont.setCont_del("N");
//		cont.setStd_id("std6");
//		
//		/***When***/
//		int result = dao.newContent(cont);
//		/***Then***/
//		assertEquals(1, result);
//	}
	
	@Test
	public void getContentnameTest(){
		/***Given***/
		String title="제발";
		BoardDaoInf dao = new BoardDao();
		
		/***When***/
		ContentVO cont = dao.getContentname(title);
		/***Then***/
		assertEquals("제발", cont.getCont_title());
	}

}
