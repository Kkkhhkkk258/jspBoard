package kr.or.ddit.student.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVO;

public class StudentDao implements StudentDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. 9.
	* 작성자 : PC14
	* 변경이력 :
	* @return
	* Method 설명 : 전체 학생 정보를 조회한다
	*/
	@Override
	public List<StudentVO> selectAllStudents() {
	
		List<StudentVO> stdList = null;
		SqlSession session = sqlSessionFactory.openSession();
		stdList =  session.selectList("student.selectAllStudents");
		session.close();
		
		return stdList;
	}

	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC14
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 학생 정보 조회
	*/
	@Override
	public StudentVO getUser(String userId) {
		StudentVO std = null;
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println(userId);
		std = (StudentVO)session.selectOne("student.getUser", userId);
		session.close();
		return std;
	}

	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC14
	* 변경이력 :
	* @param stdVO
	* @return
	* Method 설명 :학생 정보 조회
	*/
	@Override
	public StudentVO getStudent(StudentVO stdVO) {
		StudentVO std = null;
		SqlSession session = sqlSessionFactory.openSession();
		std = session.selectOne("student.getStudent", stdVO.getId());
		session.close();
		return std;
	}

	/**
	* Method : getStudentPageList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC14
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 학생 페이지 리스트 조회
	*/
	@Override
	public List<StudentVO> getStudentPageList(Map<String, Integer> map) {
		List<StudentVO> stdList = null;
		SqlSession session = sqlSessionFactory.openSession();
		stdList = session.selectList("student.getStudentPageList", map);
		session.close();
		return stdList;
	}

	@Override
	public int getStudentTotCnt() {
		int total = 0;
		SqlSession session = sqlSessionFactory.openSession();
		total = session.selectOne("student.getStudentTotCnt");
		session.close();
		return total;
	}

	@Override
	public int studentUpdate(StudentVO stdVO) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = 0;
		result = session.update("student.studentUpdate", stdVO);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public StudentVO getStudent(int id) {
		StudentVO std = null;
		SqlSession session = sqlSessionFactory.openSession();
		std = session.selectOne("student.getStudent", id);
		session.close();
		return std;
	}

	@Override
	public StudentVO getStudentStdId(String std_id) {
		StudentVO std = null;
		SqlSession s = sqlSessionFactory.openSession();
		std = s.selectOne("student.getStudentStdId", std_id);
		return std;
	}

}
