package kr.or.ddit.board.model;

public class AttachmentVO {
	private int cont_num;     // 게시글 번호
	private String att_name;  //첨부파일 이름
	private String att_path;  //첨부파일 경로
	private String att_file;  //첨부파일명
	private int att_num;      //첨부 파일 번호
	
	
	
	public int getAtt_num() {
		return att_num;
	}
	public void setAtt_num(int att_num) {
		this.att_num = att_num;
	}
	public int getCont_num() {
		return cont_num;
	}
	public void setCont_num(int cont_num) {
		this.cont_num = cont_num;
	}
	public String getAtt_name() {
		return att_name;
	}
	public void setAtt_name(String att_name) {
		this.att_name = att_name;
	}
	public String getAtt_path() {
		return att_path;
	}
	public void setAtt_path(String att_path) {
		this.att_path = att_path;
	}
	public String getAtt_file() {
		return att_file;
	}
	public void setAtt_file(String att_file) {
		this.att_file = att_file;
	}
	
	
	
}
