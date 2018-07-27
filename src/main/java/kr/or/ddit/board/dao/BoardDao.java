package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.AttachmentVO;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.CommentsVO;
import kr.or.ddit.board.model.ContentVO;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class BoardDao implements BoardDaoInf {
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	@Override
	public List<BoardVO> allBoard() {
		List<BoardVO> allBoard = null;
		SqlSession session = sqlSessionFactory.openSession();
		allBoard = session.selectList("board.allBoard");
		return allBoard;
	}

	@Override
	public int newBoard(BoardVO bd) {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		cnt = session.insert("board.newBoard", bd);
		session.commit();
		session.close();
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bd) {
		int cnt = 0;
		SqlSession s = sqlSessionFactory.openSession();
		cnt = s.update("board.updateBoard", bd);
		s.commit();
		s.close();
		return cnt;
	}

	@Override
	public BoardVO searchBoard(String name) {
		BoardVO bd = null;
		SqlSession s = sqlSessionFactory.openSession();
		bd = s.selectOne("board.searchBoard", name);
		s.close();
		return bd;
	}

	@Override
	public BoardVO searchBoardNum(int num) {
		BoardVO bd = null;
		SqlSession s = sqlSessionFactory.openSession();
		bd = s.selectOne("board.searchBoardNum", num);
		s.close();
		return bd;
	}

	@Override
	public List<ContentVO> showContents(Map<String, Object> map) {
		List<ContentVO> contents = null;
		SqlSession s = sqlSessionFactory.openSession();
		contents = s.selectList("board.showContents", map);
		s.close();
		return contents;
	}

	@Override
	public ContentVO getContent(int cont_num) {
		ContentVO content = null;
		SqlSession s = sqlSessionFactory.openSession();
		content = s.selectOne("board.getContent", cont_num);
		return content;
	}

	@Override
	public int addComments(CommentsVO comment) {
		int result = 0;
		SqlSession s = sqlSessionFactory.openSession();
		result = s.insert("board.addComments", comment);
		s.commit();
		s.close();
		return result;
	}

	@Override
	public List<CommentsVO> getComments(int cont_num) {
		List<CommentsVO> commentList = null;
		SqlSession s = sqlSessionFactory.openSession();
		commentList = s.selectList("board.getComments", cont_num);
		s.close();
		return commentList;
	}

	@Override
	public int updateContent(ContentVO cont) {
		int cnt  = 0;
		SqlSession s = sqlSessionFactory.openSession();
		cnt = s.update("board.updateContent", cont);
		s.commit();
		s.close();
		return cnt;
	}

	@Override
	public CommentsVO getCom(int com_num) {
		CommentsVO comment = null;
		SqlSession s = sqlSessionFactory.openSession();
		comment = s.selectOne("board.getCom", com_num);
		s.close();
		return comment;
	}

	@Override
	public int updateCom(CommentsVO comment) {
		int result = 0;
		SqlSession s = sqlSessionFactory.openSession();
		result = s.update("board.updateCom", comment);
		s.commit();
		return result;
	}

	@Override
	public int newContent(ContentVO content) {
		int result = 0;
		SqlSession s = sqlSessionFactory.openSession();
		result = s.insert("board.newContent", content);
		s.commit();
		s.close();
		return result;
	}

	@Override
	public int newAnswerContent(ContentVO content) {
		int result = 0;
		SqlSession s = sqlSessionFactory.openSession();
		result = s.insert("board.newAnswerContent", content);
		s.commit();
		s.close();
		return result;
	}

	@Override
	public ContentVO getContentname(String cont_title) {
		ContentVO content = null;
		SqlSession s = sqlSessionFactory.openSession();
		content = s.selectOne("board.getContentname", cont_title);
		s.close();
		return content;
	}

	@Override
	public int addAttachment(AttachmentVO att) {
		int result = 0;
		SqlSession s = sqlSessionFactory.openSession();
		result = s.insert("board.addAttachment", att);
		s.commit();
		s.close();
		return result;
	}

	@Override
	public List<AttachmentVO> getAttachList(int cont_num) {
		List<AttachmentVO> attachList = null;
		SqlSession s = sqlSessionFactory.openSession();
		attachList = s.selectList("board.getAttachList", cont_num);
		s.close();
		return attachList;
	}
	
	

	

}
