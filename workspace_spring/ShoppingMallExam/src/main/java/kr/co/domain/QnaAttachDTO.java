package kr.co.domain;

import java.io.Serializable;

public class QnaAttachDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int attachNo; //NOM
	private String attachFullName; //fullname
	private String attachRegDate; //regdate
	private int noticeNo; //게시판no
	
	
	public QnaAttachDTO() {
		// TODO Auto-generated constructor stub
	}


	public QnaAttachDTO(int attachNo, String attachFullName, String attachRegDate, int noticeNo) {
		super();
		this.attachNo = attachNo;
		this.attachFullName = attachFullName;
		this.attachRegDate = attachRegDate;
		this.noticeNo = noticeNo;
	}


	public int getAttachNo() {
		return attachNo;
	}


	public void setAttachNo(int attachNo) {
		this.attachNo = attachNo;
	}


	public String getAttachFullName() {
		return attachFullName;
	}


	public void setAttachFullName(String attachFullName) {
		this.attachFullName = attachFullName;
	}


	public String getAttachRegDate() {
		return attachRegDate;
	}


	public void setAttachRegDate(String attachRegDate) {
		this.attachRegDate = attachRegDate;
	}


	public int getNoticeNo() {
		return noticeNo;
	}


	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
