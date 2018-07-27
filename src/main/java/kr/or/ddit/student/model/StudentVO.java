package kr.or.ddit.student.model;

import java.util.Date;

import kr.or.ddit.encrypt.kisa.seed.KISA_SEED_CBC;

public class StudentVO {
	private int id;      //아이디
	private String name; // 이름
	private int call_cnt;  //호출횟수
	private Date reg_dt;  //등록일
	private String addr1; //주소1
	private String addr2; //주소2
	private String zipcd; //우편번호
	private String pic;   //프로필사진
	private String picpath;  //파일경로
	private String picname;  //파일명
	private String std_id;
	private String pass;
	
	public StudentVO(){
		
	}
	
	
	
	
	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}


	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCall_cnt() {
		return call_cnt;
	}
	public void setCall_cnt(int call_cnt) {
		this.call_cnt = call_cnt;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcd() {
		return zipcd;
	}

	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}


	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}



	

	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", name=" + name + ", call_cnt="
				+ call_cnt + ", reg_dt=" + reg_dt + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", zipcd=" + zipcd + ", pic=" + pic
				+ ", picpath=" + picpath + ", picname=" + picname + ", std_id="
				+ std_id + ", pass=" + pass + "]";
	}

	public boolean checkSuccess(String std_id, String pass){
		String password = KISA_SEED_CBC.Decrypt(this.getPass());
		if(this.getStd_id().equals(std_id) && password.equals(pass)){
			return true;
		}else{
			return false;
		}
		
	}

	
	
	
	
	
	
}
