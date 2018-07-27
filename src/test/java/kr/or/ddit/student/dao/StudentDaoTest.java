package kr.or.ddit.student.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVO;

import org.junit.Before;
import org.junit.Test;

public class StudentDaoTest {
	private StudentDaoInf studentDao ;
	
	//@Befrore -> @Test -> @After
	//테스트 메소드 안에 중복되는 내용  : StudentDao 구현체에 대한 생성 로직
	//--> @before 어노테이션이 붙은 setup메소드에 위임
	//모든 테스트 메소드에서 StudentDao 객체를 참조할 수 있게 끔 클래스 변수로 생성할 필요가 있고
	//클래스 변수를 setup메소드에서 초기화하는 로직이 필요
	
	@Before
	public void setup(){
		studentDao = new StudentDao();
	}
	
	/**
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 전체 학생 정보를 조회한다
	*/
	@Test
	public void selectAllStudents() {
		/***Given***/
		
		
		/***When***/
		List<StudentVO> stdList = studentDao.selectAllStudents();
		
		for (StudentVO vo : stdList) {
			System.out.println(vo);
		}
		
		/***Then***/
		assertEquals(25, stdList.size());
	}
	
	@Test
	public void getStudentTest(){
		/***Given***/
		
			
			
		/***When***/
		StudentVO result = studentDao.getStudent(15);
		System.out.println(result);

		/***Then***/
		assertEquals(15, result.getId());
	}
	
	@Test
	public void getStudent()
	{
		/***Given***/
		
		StudentVO test = studentDao.getStudent(25);
		
		
		/***When***/
		StudentVO result = studentDao.getStudent(test);
		System.out.println(test);
		
		/***Then***/
		assertEquals(test.getId(), result.getId());

	}
	
	@Test
	public void getStudentPageList(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
		
		/***When***/
		List<StudentVO> test = studentDao.getStudentPageList(map);
		System.out.println("getStudentPage List-----------------");
		for(StudentVO std : test){
			System.out.println(std);
		}
		System.out.println("-----------------------------------------------");
		
		/***Then***/
		assertEquals(10, test.size());
	}
	
	@Test
	public void getStudentTotCnt(){
		/***Given***/
		List<StudentVO> stdList = studentDao.selectAllStudents();
		/***When***/
		int total = studentDao.getStudentTotCnt();
		/***Then***/
		assertEquals(stdList.size(), total);
	}
	
	@Test
	public void studentUpdateTest(){
		
		/***Given***/
		StudentVO stdVO = new StudentVO();
		stdVO.setId(12);
		stdVO.setName("강병관");
		stdVO.setAddr1("대전 광역시 중구 중앙로 76");
		stdVO.setAddr2("영민빌딩 2층 대덕인재개발원");
		stdVO.setPic("sally.png");
		stdVO.setPicpath("D:/A_TeachingMaterial/7.JspSrpgin/fileUpload");
		stdVO.setPicname("eb42cca7-5cfd-46aa-b25a-a2a6c33acbfc");
		stdVO.setZipcd("34940");
		/***When***/
		int result = studentDao.studentUpdate(stdVO);

		/***Then***/
		assertEquals(1, result);

	}
	
	@Test
	public void getStudentStdIdTest(){
		/***Given***/
		String stdId = "blue";
		
		/***When***/
		StudentVO std = studentDao.getStudentStdId(stdId);
		
		/***Then***/
		assertEquals("강병관", std.getName());
	}
	
}
