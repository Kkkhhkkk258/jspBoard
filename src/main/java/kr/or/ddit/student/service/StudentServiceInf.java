package kr.or.ddit.student.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVO;

public interface StudentServiceInf {
	
	/**
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. .
	* 작성자 : PC14
	* 변경이력 :
	* @return
	* Method 설명 : 전체 학생 정보를 조회한다
	*/
	List<StudentVO> selectAllStudents();
	
	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC14
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :학생 정보 조회
	*/
	StudentVO getUser(String userId);
	
	StudentVO getStudent(int id);
	
	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC14
	* 변경이력 :
	* @param stdVO
	* @return
	* Method 설명 : 학생 정보 조회
	*/
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
	Map<String, Object> getStudentPageList(Map<String, Integer> map);
	
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
