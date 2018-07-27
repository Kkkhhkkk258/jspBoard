package kr.or.ddit.board.model;

import java.util.Date;

public class ContentVO {
	private int cont_num;       //게시글 번호
	private String cont_title;  //게시글 제목
	private int board_num;      //게시판 번호
	private String cont_detail; //게시글 내용 
	private Date cont_date;     //작성일시
	private String cont_del;    //게시글 삭제여부
	private String std_id;      //학생아이디
	private int cont_pa;        //게시글 부모 번호
	private int cont_group;     //게시글 그룹 번호
	
	
	public int getCont_num() {
		return cont_num;
	}
	public void setCont_num(int cont_num) {
		this.cont_num = cont_num;
	}
	public String getCont_title() {
		return cont_title;
	}
	public void setCont_title(String cont_title) {
		this.cont_title = cont_title;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getCont_detail() {
		return cont_detail;
	}
	public void setCont_detail(String cont_detail) {
		this.cont_detail = cont_detail;
	}
	public Date getCont_date() {
		return cont_date;
	}
	public void setCont_date(Date cont_date) {
		this.cont_date = cont_date;
	}
	public String getCont_del() {
		return cont_del;
	}
	public void setCont_del(String cont_del) {
		this.cont_del = cont_del;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public int getCont_pa() {
		return cont_pa;
	}
	public void setCont_pa(int cont_pa) {
		this.cont_pa = cont_pa;
	}
	public int getCont_group() {
		return cont_group;
	}
	public void setCont_group(int cont_group) {
		this.cont_group = cont_group;
	}
	@Override
	public String toString() {
		return "ContentVO [cont_num=" + cont_num + ", cont_title=" + cont_title
				+ ", board_num=" + board_num + ", cont_detail=" + cont_detail
				+ ", cont_date=" + cont_date + ", cont_del=" + cont_del
				+ ", std_id=" + std_id + ", cont_pa=" + cont_pa
				+ ", cont_group=" + cont_group + "]";
	}
	
	
	
}
