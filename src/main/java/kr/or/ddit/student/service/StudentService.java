package kr.or.ddit.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVO;

public class StudentService implements StudentServiceInf {
	private StudentDaoInf stdDao = new StudentDao();

	/**
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC14
	* 변경이력 :
	* @return
	* Method 설명 : 전체 학생 정보를 조회한다
	*/
	@Override
	public List<StudentVO> selectAllStudents() {
		return stdDao.selectAllStudents();
	}

	@Override
	public StudentVO getUser(String userId) {
		return stdDao.getUser(userId);
	}

	@Override
	public StudentVO getStudent(StudentVO stdVO) {
		return stdDao.getStudent(stdVO);
	}

	/**
	* Method : getStudentPageList
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC14
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 :학생 정보 페이지 리스트 조회
	*/
	@Override
	public Map<String, Object> getStudentPageList(Map<String, Integer> map) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//학생 페이지 리스트 조회
		List<StudentVO> stdList = stdDao.getStudentPageList(map);
		resultMap.put("pageList", stdList);
		
		//학생 전체 건수 조회
		int totCnt = stdDao.getStudentTotCnt();
		resultMap.put("totCnt", totCnt);
		
		//페이지 네비게이션 html 생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		
		
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt) );
		
		
		return resultMap;
	}
	
	/**
	* Method : makePageNavi
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC14
	* 변경이력 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @return
	* Method 설명 : 페이지 네비게이션 문자열 생성
	*/
	private String makePageNavi(int page, int pageSize, int totCnt){
		
		int cnt = totCnt / pageSize;
		int mod = totCnt % pageSize;
		
		if(mod > 0){
			cnt++;
		}
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page ==1 ? 1 : page-1;
		int nextPage = page ==3 ? 3 : page+1;
		pageNaviStr.append("<li><a href=\"/studentList?page="+prevPage+"&pageSize="+pageSize+"\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a> </li>");
		for(int i =1; i <=cnt; i++){
			String activeClass="";
			if(i == page){
				activeClass = "class=\"active\"";
				pageNaviStr.append("<li "+activeClass+"><a href=\"/studentList?page="+i+"&pageSize="+pageSize+"\">"+i+"</a></li>");
			}else{
				pageNaviStr.append("<li><a href=\"/studentList?page="+i+"&pageSize="+pageSize+"\">"+i+"</a></li>");
				
			}
			
		}
		
		pageNaviStr.append("<li><a href=\"/studentList?page="+nextPage+"&pageSize="+pageSize+"\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		return pageNaviStr.toString();
		
	}

	@Override
	public int studentUpdate(StudentVO stdVO) {
		return stdDao.studentUpdate(stdVO);
	}

	@Override
	public StudentVO getStudent(int id) {
		return stdDao.getStudent(id);
	}

	@Override
	public StudentVO getStudentStdId(String std_id) {
		return stdDao.getStudentStdId(std_id);
	}

	

}
