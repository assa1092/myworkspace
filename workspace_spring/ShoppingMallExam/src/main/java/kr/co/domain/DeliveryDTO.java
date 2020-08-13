package kr.co.domain;

import java.io.Serializable;

public class DeliveryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String deliveryName; //배송지명
	private String deliveryCustomer; //성명
	private String deliveryCode; //우편번호
	private String deliveryAddress_1; //주소
	private String deliveryAddress_2; //상세주소
	private String deliveryTel; //전화번호
	private String deliveryPhone; //핸드폰
	private String memberId; //회원ID
	private int deliveryNo; //no

	public DeliveryDTO(String deliveryName, String deliveryCustomer, String deliveryCode, String deliveryAddress_1,
			String deliveryAddress_2, String deliveryTel, String deliveryPhone, int deliveryNo, String memberId) {
		super();
		this.deliveryName = deliveryName;
		this.deliveryCustomer = deliveryCustomer;
		this.deliveryCode = deliveryCode;
		this.deliveryAddress_1 = deliveryAddress_1;
		this.deliveryAddress_2 = deliveryAddress_2;
		this.deliveryTel = deliveryTel;
		this.deliveryPhone = deliveryPhone;
		this.deliveryNo = deliveryNo;
		this.memberId = memberId;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryCustomer() {
		return deliveryCustomer;
	}

	public void setDeliveryCustomer(String deliveryCustomer) {
		this.deliveryCustomer = deliveryCustomer;
	}

	public String getDeliveryCode() {
		return deliveryCode;
	}

	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}

	public String getDeliveryAddress_1() {
		return deliveryAddress_1;
	}

	public void setDeliveryAddress_1(String deliveryAddress_1) {
		this.deliveryAddress_1 = deliveryAddress_1;
	}

	public String getDeliveryAddress_2() {
		return deliveryAddress_2;
	}

	public void setDeliveryAddress_2(String deliveryAddress_2) {
		this.deliveryAddress_2 = deliveryAddress_2;
	}

	public String getDeliveryTel() {
		return deliveryTel;
	}

	public void setDeliveryTel(String deliveryTel) {
		this.deliveryTel = deliveryTel;
	}

	public String getDeliveryPhone() {
		return deliveryPhone;
	}

	public void setDeliveryPhone(String deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
	}

	public int getDeliveryNo() {
		return deliveryNo;
	}
	
	public void setDeliveryNo(int deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


}

