package com.tg.board;

import java.util.Date;

public class BoardDto {

	private int no = 0;
	private int mNo = 0;
	private String writer = "";
	private String title = ""; 
	private String content = "";
	private Date creDate = null;
	private Date modDate = null;
		
	
	public BoardDto() {
		super();
	}
	
	public BoardDto(int no, String writer, String title, Date creDate, Date modDate) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.creDate = creDate;
		this.modDate = modDate;
	}

	
	
	public BoardDto(int no, String writer, String title, String content, Date creDate, Date modDate) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.creDate = creDate;
		this.modDate = modDate;
	}

	
	public BoardDto(int no, int mNo, String title, String content, Date creDate, Date modDate) {
		super();
		this.no = no;
		this.mNo = mNo;
		this.title = title;
		this.content = content;
		this.creDate = creDate;
		this.modDate = modDate;
	}

	public BoardDto(int no, int mNo, String writer, String title, String content, Date creDate, Date modDate) {
		super();
		this.no = no;
		this.mNo = mNo;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.creDate = creDate;
		this.modDate = modDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreDate() {
		return creDate;
	}

	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	
	
	
}
