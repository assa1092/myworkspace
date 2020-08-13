package kr.co.domain;

import java.io.Serializable;

public class ReviewAttachDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int attachNo; //NOM
	private String attachFullName; //fullname
	private String attachRegDate; //regdate
	private int reviewNo; //게시판no
	
	public ReviewAttachDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReviewAttachDTO(int attachNo, String attachFullName, String attachRegDate, int reviewNo) {
		super();
		this.attachNo = attachNo;
		this.attachFullName = attachFullName;
		this.attachRegDate = attachRegDate;
		this.reviewNo = reviewNo;
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

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
