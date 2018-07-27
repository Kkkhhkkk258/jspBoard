package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.CommentsVO;
import kr.or.ddit.board.model.ContentVO;

import org.junit.Test;

public class BoardServiceTest {

	@Test
	public void test() {
		/***Given***/
		BoardServiceInf ser = new BoardService();
		List<BoardVO> list = null;
		/***When***/
		list = ser.allBoard();
		
		/***Then***/
		assertEquals(3, list.size());
	}
	
//	@Test
//	public void newTest(){
//		/***Given***/
//		BoardServiceInf s = new BoardService();
//		BoardVO b = new BoardVO();
//		b.setBoard_name("test2");
//		b.setBoard_use("y");
//		/***When***/
//		int result = s.newBoard(b);
//		/***Then***/
//		assertEquals(1, result);
//
//	}
	
//	@Test
//	public void searchTest(){
//		/***Given***/
//		BoardServiceInf s = new BoardService();
//		String name ="자유게시판";
//		/***When***/
//		BoardVO  b = s.searchBoard(name);
//
//		/***Then***/
//		assertEquals(name, b.getBoard_name());
//
//	}
	
//	@Test
//	public void updateTest(){
//		/***Given***/
//		BoardServiceInf s = new BoardService();
//		BoardVO b = s.searchBoard("Test");
//		b.setBoard_name("test");
//		b.setBoard_use("Y");
//		/***When***/
//		int result = s.updateBoard(b);
//		
//		/***Then***/
//		assertEquals("test", b.getBoard_name());
//	}
	
	@Test
	public void contentListTest(){
		/***Given***/
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board_num", 1);
		map.put("page", 1);
		map.put("pageSize", 10);
		BoardServiceInf s = new BoardService();
		
		/***When***/
		List<ContentVO> contents = s.contentList(map); 
		/***Then***/
		assertEquals(3, contents.size());
	}
	
	@Test
	public void showContentTest(){
		/***Given***/
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", 1);
		map.put("pageSize", 10);
		map.put("board_num", 2);
		BoardServiceInf s = new BoardService();
		
		/***When***/
		List<ContentVO> contentList = (List<ContentVO>) s.showContents(map).get("contentList");
		
		/***Then***/
		assertEquals(1, contentList.size());

	}
	
//	@Test
//	public void addCommentTest(){
//		/***Given***/
//		BoardServiceInf s = new BoardService();
//		CommentsVO comm = new CommentsVO();
//		comm.setCom_del("Y");
//		comm.setCom_detail("삭제된거 해볼까");
//		comm.setCont_num(1);
//		comm.setStd_id("std9");
//		/***When***/
//		int result = s.addComments(comm);
//		/***Then***/
//		assertEquals(1, result);
//	}
	
	@Test
	public void getCommentsTest(){
		/***Given***/
		List<CommentsVO> list = null;
		BoardServiceInf s = new BoardService();
		int cont_num = 1;
		/***When***/
		list = s.getComments(cont_num);
		/***Then***/
		assertEquals(5, list.size());

	}
	
	@Test
	public void updateContentTest(){
		/***Given***/
		int result = 0;
		BoardServiceInf s = new BoardService();
		ContentVO cont = s.getContent(5);
		cont.setCont_detail("불가능이야...안해 못해 ");
		/***When***/
		result = s.updateContent(cont);
		/***Then***/
		assertEquals(1, result);

	}

}
