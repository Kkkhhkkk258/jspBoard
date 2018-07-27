package kr.or.ddit.student.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVO;

import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {
	private StudentServiceInf stdService;
	
	@Before
	public void setup(){
		stdService = new StudentService();
	}

	@Test
	public void selectAllStudentstest() {
		/***Given***/
		
		/***When***/
		List<StudentVO> stdList = stdService.selectAllStudents();
				
		for (StudentVO vo : stdList) {
					System.out.println(vo);
			}
		/***Then***/
		assertEquals(25, stdList.size());

	}
	
	/**
	* Method : getStudentTest
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 학생 정보 조회
	*/
	@Test
	public void getStudentTest(){
		/***Given***/
			
			
		/***When***/
		StudentVO result = stdService.getStudent(15);
		System.out.println(result);

		/***Then***/
		assertEquals(15, result.getId());
	}
	
	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 학생 정보 조회
	*/
	@Test
	public void getStudent()
	{
		/***Given***/
		StudentVO test = stdService.getStudent(25);
		
		
		/***When***/
		StudentVO result = stdService.getStudent(test);
		System.out.println(test);
		
		/***Then***/
		assertEquals(test.getId(), result.getId());

	}
	
	/**
	* Method : getStudentPageList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 학생 페이지 리스트 조회(3page 5건)
	*/
	@Test
	public void getStudentPageList(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 3);
		map.put("pageSize", 10);
		
		/***When***/
		Map<String, Object> resultMap = stdService.getStudentPageList(map);
		
		List<StudentVO> test = (List<StudentVO>) resultMap.get("pageList");
		
		int totCnt = (int)resultMap.get("totCnt");
//		List<StudentVO> test = stdService.getStudentPageList(map);
		
		/***Then***/
		assertEquals(25,totCnt);
//		assertEquals(10,test.size());

	}
	/**
	* Method : calculatePageNavi
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC14
	* 변경이력 :
	* Method 설명 : 전체 건수를 인자로 페이지 네비게이션 사이즈를 구하는 테스트
	*/
	@Test
	public void calculatePageNavi(){
		/***Given***/
		int totCnt = 25;
		int pageSize = 10;
		
		int cnt = totCnt/pageSize;
		int mod = totCnt % pageSize;
		
		/***When***/
		if(mod >0){
			cnt++;
		}
		/***Then***/
		assertEquals(3, cnt);
	}
	
	@Test
	public void studentUpdate(){
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
		int result = stdService.studentUpdate(stdVO);

		/***Then***/
		assertEquals(1, result);
	}
	
	@Test
	public void getStudentStdIdTest(){
		/***Given***/
		String stdId = "std1";
		/***When***/
		StudentVO std = stdService.getStudentStdId(stdId);
		
		/***Then***/
		assertEquals("임수빈", std.getName());
	}
	
	

}
