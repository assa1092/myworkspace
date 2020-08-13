package kr.co.domain;

import java.io.Serializable;

public class ReviewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int reviewNo; //NO
	private int productNo; //상품번호
	private String memberId; //작성자
	private String reviewContent; //내용
	private String reviewRegDate; //작성일자
	private String reviewTitle; //제목
	private int reviewReadCnt; //조회수
	private int reviewScore; //별점
	private String petKind; //견종/묘종
	private int petWeight; //몸무게
	private String petSize; //평소사이즈
	private int isDelete; //삭제여부
	
	public ReviewDTO() {

	}

	public ReviewDTO(int reviewNo, int productNo, String memberId, String reviewContent, String reviewRegDate,
			String reviewTitle, int reviewReadCnt, int reviewScore, String petKind, int petWeight, String petSize,
			int isDelete) {
		super();
		this.reviewNo = reviewNo;
		this.productNo = productNo;
		this.memberId = memberId;
		this.reviewContent = reviewContent;
		this.reviewRegDate = reviewRegDate;
		this.reviewTitle = reviewTitle;
		this.reviewReadCnt = reviewReadCnt;
		this.reviewScore = reviewScore;
		this.petKind = petKind;
		this.petWeight = petWeight;
		this.petSize = petSize;
		this.isDelete = isDelete;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewRegDate() {
		return reviewRegDate;
	}

	public void setReviewRegDate(String reviewRegDate) {
		this.reviewRegDate = reviewRegDate;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public int getReviewReadCnt() {
		return reviewReadCnt;
	}

	public void setReviewReadCnt(int reviewReadCnt) {
		this.reviewReadCnt = reviewReadCnt;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getPetKind() {
		return petKind;
	}

	public void setPetKind(String petKind) {
		this.petKind = petKind;
	}

	public int getPetWeight() {
		return petWeight;
	}

	public void setPetWeight(int petWeight) {
		this.petWeight = petWeight;
	}

	public String getPetSize() {
		return petSize;
	}

	public void setPetSize(String petSize) {
		this.petSize = petSize;
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

