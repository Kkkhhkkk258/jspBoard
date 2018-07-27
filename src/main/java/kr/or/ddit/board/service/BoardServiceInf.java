package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.AttachmentVO;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.CommentsVO;
import kr.or.ddit.board.model.ContentVO;

public interface BoardServiceInf {
	/**
	* Method : allBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC14
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판 리스트
	*/
	List<BoardVO> allBoard();
	
	/**
	* Method : newBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC14
	* 변경이력 :
	* @param bd
	* @return
	* Method 설명 :새 게시판
	*/
	int newBoard(BoardVO bd);
	
	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC14
	* 변경이력 :
	* @param bd
	* @return
	* Method 설명 : 게시판 수정
	*/
	int updateBoard(BoardVO bd);
	
	/**
	* Method : searchBoard
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC14
	* 변경이력 :
	* @param name
	* @return
	* Method 설명 : 게시판 이름으로 게시판 찾기
	*/
	BoardVO searchBoard(String name);
	
	/**
	* Method : searchBoard
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC14
	* 변경이력 :
	* @param num
	* @return
	* Method 설명 : 게시판 이름으로 게시판 찾기
	*/
	BoardVO searchBoardNum(int num);
	
	List<ContentVO> contentList(Map<String, Object> map);
	
	Map<String, Object> showContents(Map<String, Object> map);

	/**
	 * Method : getContent
	 * 최초작성일 : 2018. 7. 22.
	 * 작성자 : khyun
	 * 변경이력 :
	 * @param cont_num
	 * @return
	 * Method 설명 : 게시글 번호로 게시글 찾기
	 */
	ContentVO getContent(int cont_num);
	
	/**
	 * Method : addComments
	 * 최초작성일 : 2018. 7. 22.
	 * 작성자 : khyun
	 * 변경이력 :
	 * @param comment
	 * @return
	 * Method 설명 : 댓글 쓰기
	 */
	int addComments(CommentsVO comment);
	
	/**
	 * Method : getComments
	 * 최초작성일 : 2018. 7. 22.
	 * 작성자 : khyun
	 * 변경이력 :
	 * @param cont_num
	 * @return
	 * Method 설명 : 댓글 불러오기 
	 */
	List<CommentsVO> getComments(int cont_num);
	
	/**
	 * Method : updateContent
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : khyun
	 * 변경이력 :
	 * @param cont
	 * @return
	 * Method 설명 : 게시글 수정이욤
	 */
	int updateContent(ContentVO cont);
	
	/**
	 * Method : getCom
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : khyun
	 * 변경이력 :
	 * @param com_num
	 * @return
	 * Method 설명 : 댓글 번호로 댓글 불러오기
	 */
	CommentsVO getCom(int com_num);
	
	int updateCom(CommentsVO comment);
	
	/**
	 * Method : newContent
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : khyun
	 * 변경이력 :
	 * @param content
	 * @return
	 * Method 설명 : 새게시글 쓰기
	 */
	int newContent(ContentVO content);
	
	/**
	 * Method : newAnswerContent
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : khyun
	 * 변경이력 :
	 * @param content
	 * @return
	 * Method 설명 : 새답글쓰기
	 */
	int newAnswerContent(ContentVO content);
	
	/**
	 * Method : getContentname
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : khyun
	 * 변경이력 :
	 * @param cont_title
	 * @return
	 * Method 설명 : 글제목으로 게시글 찾기
	 */
	ContentVO getContentname(String cont_title);
	
	/**
	 * Method : addAttachment
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : khyun
	 * 변경이력 :
	 * @param att
	 * @return
	 * Method 설명 : 첨부파일 저장
	 */
	int addAttachment(AttachmentVO att);
	
	/**
	 * Method : getAttachList
	 * 최초작성일 : 2018. 7. 24.
	 * 작성자 : khyun
	 * 변경이력 :
	 * @param cont_num
	 * @return
	 * Method 설명 : 게시글의 첨부파일 리스트 가져오기
	 */
	List<AttachmentVO> getAttachList(int cont_num); 
	
}
