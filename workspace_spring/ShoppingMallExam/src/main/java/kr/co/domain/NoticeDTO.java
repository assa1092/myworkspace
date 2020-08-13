package kr.co.domain;

import java.io.Serializable;

public class NoticeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int noticeNo; // no
	private String noticeTitle; // 제목
	private String noticeRegDate; // 작성일자
	private String noticeContent; // 내용
	private int noticeReadCnt; // 조회수
	private int isDelete; // 삭제여부

	public NoticeDTO() {

	}

	public NoticeDTO(int noticeNo, String noticeTitle, String noticeRegDate, String noticeContent, int noticeReadCnt,
			int isDelete) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeRegDate = noticeRegDate;
		this.noticeContent = noticeContent;
		this.noticeReadCnt = noticeReadCnt;
		this.isDelete = isDelete;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeRegDate() {
		return noticeRegDate;
	}

	public void setNoticeRegDate(String noticeRegDate) {
		this.noticeRegDate = noticeRegDate;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public int getNoticeReadCnt() {
		return noticeReadCnt;
	}

	public void setNoticeReadCnt(int noticeReadCnt) {
		this.noticeReadCnt = noticeReadCnt;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}