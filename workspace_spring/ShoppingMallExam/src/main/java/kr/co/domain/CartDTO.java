package kr.co.domain;

import java.io.Serializable;

public class CartDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int cartNo; //no		
	private int productNo; //상품번호		
	private String memberId; //회원ID		
	private int cartAmount; //수량		


	public CartDTO() {
		// TODO Auto-generated constructor stub
	}


	public CartDTO(int cartNo, int productNo, String memberId, int cartAmount) {
		super();
		this.cartNo = cartNo;
		this.productNo = productNo;
		this.memberId = memberId;
		this.cartAmount = cartAmount;
	}


	public int getCartNo() {
		return cartNo;
	}


	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
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


	public int getCartAmount() {
		return cartAmount;
	}


	public void setCartAmount(int cartAmount) {
		this.cartAmount = cartAmount;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

