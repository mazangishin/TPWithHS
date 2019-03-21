package com.tg.member;

import java.util.Date;

public class MemberDto {

	private int memberNo = 0;
	private String memberName = "";
	private String email = "";
	private String password = "";
	private Date createDate = null;
	
	public MemberDto() {
		
	}

	public MemberDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public MemberDto(int memberNo, String memberName, String email, Date createDate) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.email = email;
		this.createDate = createDate;
	}

	public MemberDto(int memberNo, String memberName, String email, String password, Date createDate) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.email = email;
		this.password = password;
		this.createDate = createDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
