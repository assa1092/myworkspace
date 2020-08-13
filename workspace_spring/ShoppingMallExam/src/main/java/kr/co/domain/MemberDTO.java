package kr.co.domain;

import java.io.Serializable;
import java.util.Date;

public class MemberDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int memberNo; // 회원번호
	private String memberId; // 아이디
	private String memberPw; // 비밀번호
	private String memberName; // 이름
	private String memberBirth; // 생일
	private String memberZipcode; // 우편
	private String memberAddress_1; // 주소
	private String memberAddress_2; // 상세주소
	private String memberTel; // 일반전화
	private String memberPhone; // 핸드폰
	private String memberGender; // 성별
	private String memberPetName; // 동물이름
	private String memberPetAge; // 동물나이
	private String memberHolder; // 예금주
	private String memberAccount; // 계좌번호
	private String memberBank; // 은행
	private Date memberRegDate; // 가입일
	private String memberEmail; // 이메일
	private int isDelete; // 삭제여부
	private int memberGrade; // 등급
	private int memberPoint; // 포인트
		
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberZipcode() {
		return memberZipcode;
	}

	public void setMemberZipcode(String memberZipcode) {
		this.memberZipcode = memberZipcode;
	}

	public String getMemberAddress_1() {
		return memberAddress_1;
	}

	public void setMemberAddress_1(String memberAddress_1) {
		this.memberAddress_1 = memberAddress_1;
	}

	public String getMemberAddress_2() {
		return memberAddress_2;
	}

	public void setMemberAddress_2(String memberAddress_2) {
		this.memberAddress_2 = memberAddress_2;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberPetName() {
		return memberPetName;
	}

	public void setMemberPetName(String memberPetName) {
		this.memberPetName = memberPetName;
	}

	public String getMemberPetAge() {
		return memberPetAge;
	}

	public void setMemberPetAge(String memberPetAge) {
		this.memberPetAge = memberPetAge;
	}

	public String getMemberHolder() {
		return memberHolder;
	}

	public void setMemberHolder(String memberHolder) {
		this.memberHolder = memberHolder;
	}

	public String getMemberAccount() {
		return memberAccount;
	}

	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}

	public String getMemberBank() {
		return memberBank;
	}

	public void setMemberBank(String memberBank) {
		this.memberBank = memberBank;
	}

	public Date getMemberRegDate() {
		return memberRegDate;
	}

	public void setMemberRegDate(Date memberRegDate) {
		this.memberRegDate = memberRegDate;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public int getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}