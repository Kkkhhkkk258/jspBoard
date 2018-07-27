package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVO;

public interface StudentDaoInf {
	
	/**
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. 9.
	* 작성자 : PC14
	* 변경이력 :
	* @return
	* Method 설명 : 전체 학생 정보를 조회한다
	*/
	List<StudentVO> selectAllStudents();
	
	StudentVO getUser(String userId);
	
	StudentVO getStudent(int id);
	
	StudentVO getStudent(StudentVO stdVO);
	
	/**
	* Method : getStudentPageList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC14
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 학생 페이지 리스트 조회
	*/
	List<StudentVO> getStudentPageList(Map<String, Integer> map);
	
	/**
	* Method : getStudentTotCnt
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC14
	* 변경이력 :
	* @return
	* Method 설명 : 전체 건수
	*/
	int getStudentTotCnt();
	
	/**
	* Method : studentUpdate
	* 최초작성일 : 2018. 7. 17.
	* 작성자 : PC14
	* 변경이력 :
	* @param stdVO
	* @return
	* Method 설명 : 학생 정보 업데이트
	*/
	int studentUpdate(StudentVO stdVO);
	
	StudentVO getStudentStdId(String std_id);

	
}
