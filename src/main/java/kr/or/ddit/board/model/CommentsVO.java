package kr.or.ddit.board.model;

import java.util.Date;

public class CommentsVO {
	private int cont_num;       //게시글번호
	private String com_detail;  //댓글내용
	private String com_del;     //댓글 삭제여부
	private Date com_date;      //작성일자
	private String std_id;      //학생아이디
	private int com_num;
	
	
	
	public int getCom_num() {
		return com_num;
	}
	public void setCom_num(int com_num) {
		this.com_num = com_num;
	}
	public int getCont_num() {
		return cont_num;
	}
	public void setCont_num(int cont_num) {
		this.cont_num = cont_num;
	}
	public String getCom_detail() {
		return com_detail;
	}
	public void setCom_detail(String com_detail) {
		this.com_detail = com_detail;
	}
	public String getCom_del() {
		return com_del;
	}
	public void setCom_del(String com_del) {
		this.com_del = com_del;
	}
	public Date getCom_date() {
		return com_date;
	}
	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	@Override
	public String toString() {
		return "CommentsVO [cont_num=" + cont_num + ", com_detail="
				+ com_detail + ", com_del=" + com_del + ", com_date="
				+ com_date + ", std_id=" + std_id + "]";
	}
	
	
	
	
}
