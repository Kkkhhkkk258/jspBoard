package kr.or.ddit.board.model;

public class BoardVO {
	private int board_num;      //게시판번호
	private String board_name;  //게시판이름
	private String board_use;   //게시판 사용여부
	
	
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_use() {
		return board_use;
	}
	public void setBoard_use(String board_use) {
		this.board_use = board_use;
	}
	@Override
	public String toString() {
		return "BoardVO [board_num=" + board_num + ", board_name=" + board_name
				+ ", board_use=" + board_use + "]";
	}
	
	
	
}
