package kr.co.domain;

import java.io.Serializable;

public class FaqDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int faqNo; // no
	private String faqTitle; // 제목
	private String faqRegDate; // 작성일자
	private String faqContent; // 내용
	private int faqReadCnt; // 조회수
	private String faqCategory; // 카테고리
	private int isDelete; // 삭제여부

	public FaqDTO() {

	}

	public FaqDTO(int faqNo, String faqTitle, String faqRegDate, String faqContent, int faqReadCnt, String faqCategory,
			int isDelete) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqRegDate = faqRegDate;
		this.faqContent = faqContent;
		this.faqReadCnt = faqReadCnt;
		this.faqCategory = faqCategory;
		this.isDelete = isDelete;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFagNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqRegDate() {
		return faqRegDate;
	}

	public void setFaqRegDate(String faqRegDate) {
		this.faqRegDate = faqRegDate;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}

	public int getFaqReadCnt() {
		return faqReadCnt;
	}

	public void setFaqReadCnt(int faqReadCnt) {
		this.faqReadCnt = faqReadCnt;
	}

	public String getFaqCategory() {
		return faqCategory;
	}

	public void setFaqCategory(String faqCategory) {
		this.faqCategory = faqCategory;
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