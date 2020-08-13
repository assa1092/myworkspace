package kr.co.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int productNo; //상품번호
	private String productName; //상품이름
	private int productPrice; //가격
	private int productDiscountRate; //가격할인율
	private String productSet; //세트
	private int isDelete; //삭제 여부
	private int sellStatus; //판매상태
	private String[] files; //첨부파일
	private List<ProductOptionDTO> productOptionList; //상품옥션
	private int categoryNo;//카테고리번호
	private String categoryName;//카테고리이름
	private Date regDate;//등록일
	private int productDiscountPrice;//판매가(할인적용)
	private int productTotalQuantity;//상품재고합계
	
	public ProductDTO() {

	}
	
	public ProductDTO(int productNo, String productName, int productPrice, int productDiscountRate, String productSet,
			int isDelete, int sellStatus, String[] files, List<ProductOptionDTO> productOptionList, int categoryNo,
			String categoryName, Date regDate, int productDiscountPrice, int productTotalQuantity) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDiscountRate = productDiscountRate;
		this.productSet = productSet;
		this.isDelete = isDelete;
		this.sellStatus = sellStatus;
		this.files = files;
		this.productOptionList = productOptionList;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.regDate = regDate;
		this.productDiscountPrice = productDiscountPrice;
		this.productTotalQuantity = productTotalQuantity;
	}


	public int getProductTotalQuantity() {
		return productTotalQuantity;
	}

	public void setProductTotalQuantity(int productTotalQuantity) {
		this.productTotalQuantity = productTotalQuantity;
	}

	public int getProductDiscountPrice() {
		return productDiscountPrice;
	}

	public void setProductDiscountPrice(int productDiscountPrice) {
		this.productDiscountPrice = productDiscountPrice;
	}

	public String getCategoryName() {
			return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductDiscountRate() {
		return productDiscountRate;
	}

	public void setProductDiscountRate(int productDiscountRate) {
		this.productDiscountRate = productDiscountRate;
	}

	public String getProductSet() {
		return productSet;
	}

	public void setProductSet(String productSet) {
		this.productSet = productSet;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getSellStatus() {
		return sellStatus;
	}

	public void setSellStatus(int sellStatus) {
		this.sellStatus = sellStatus;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public List<ProductOptionDTO> getProductOptionList() {
		return productOptionList;
	}

	public void setProductOptionList(List<ProductOptionDTO> productOptionList) {
		this.productOptionList = productOptionList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ProductDTO(int productNo, int isDelete, int sellStatus) {
		super();
		this.productNo = productNo;
		this.isDelete = isDelete;
		this.sellStatus = sellStatus;
	}	
		
}

