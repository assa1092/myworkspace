package kr.co.domain;

import java.io.Serializable;

public class ProductOptionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int productNo; //상품번호
	private String productColor; //색깔
	private String productSize; //사이즈
	private int productQuantity; //수량
	private int productOptionNo; //no
	private int isDelete; //삭제여부
	
	public ProductOptionDTO() {

	}

	

	public ProductOptionDTO(int productNo, String productColor, String productSize, int productQuantity,
			int productOptionNo, int isDelete) {
		super();
		this.productNo = productNo;
		this.productColor = productColor;
		this.productSize = productSize;
		this.productQuantity = productQuantity;
		this.productOptionNo = productOptionNo;
		this.isDelete = isDelete;
	}



	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getProductOptionNo() {
		return productOptionNo;
	}

	public void setProductOptionNo(int productOptionNo) {
		this.productOptionNo = productOptionNo;
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


	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	
}
