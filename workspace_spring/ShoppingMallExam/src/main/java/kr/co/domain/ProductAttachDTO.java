package kr.co.domain;

import java.io.Serializable;

public class ProductAttachDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int attachNo; //NOM
	private String attachFullName; //fullname
	private String attachRegDate; //regdate
	private int productNo; //게시판no
	
	public ProductAttachDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductAttachDTO(int attachNo, String attachFullName, String attachRegDate, int productNo) {
		super();
		this.attachNo = attachNo;
		this.attachFullName = attachFullName;
		this.attachRegDate = attachRegDate;
		this.productNo = productNo;
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

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
