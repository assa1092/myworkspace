package kr.co.domain;

import java.io.Serializable;

public class WishlistDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int wishNo; //no
	private int productNo; //상품번호
	private String memberId; //회원ID
	
	public WishlistDTO() {

	}

	public WishlistDTO(int wishNo, int productNo, String memberId) {
		super();
		this.wishNo = wishNo;
		this.productNo = productNo;
		this.memberId = memberId;
	}

	public int getWishNo() {
		return wishNo;
	}

	public void setWishNo(int wishNo) {
		this.wishNo = wishNo;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}