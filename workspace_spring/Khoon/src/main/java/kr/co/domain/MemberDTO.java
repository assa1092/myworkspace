package kr.co.domain;

public class MemberDTO {
	/*
	create table member (
	    userId      varchar2(50)    not null,
	    userPw    varchar2(100)   not null,
	    userName    varchar2(30)    not null,
	    userPhone    varchar2(20)    not null,
	    userAddr1   varchar2(20)    null,
	    userAddr2   varchar2(50)    null,
	    userAddr3   varchar2(50)    null,
	    regDate    date            default sysdate,
	    verify      number          default 0,
	    primary key(userId)
	);
	*/
	private String userId;		//아이디
	private String userPw;		// 비번
	private String userName;	// 닉네임
	private String userPhone;	// 연락처
	private String userAddr1;	// 우편번호
	private String userAddr2;	// 주소
	private String userAddr3;	// 상세주소
	private String regDate;		// 가입날짜
	private int verify;			// 가입여부
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MemberDTO [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userPw == null) ? 0 : userPw.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userPw == null) {
			if (other.userPw != null)
				return false;
		} else if (!userPw.equals(other.userPw))
			return false;
		return true;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddr1() {
		return userAddr1;
	}

	public void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	}

	public String getUserAddr2() {
		return userAddr2;
	}

	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}

	public String getUserAddr3() {
		return userAddr3;
	}

	public void setUserAddr3(String userAddr3) {
		this.userAddr3 = userAddr3;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}

	public MemberDTO(String userId, String userPw, String userName, String userPhone, String userAddr1,
			String userAddr2, String userAddr3, String regDate, int verify) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userAddr1 = userAddr1;
		this.userAddr2 = userAddr2;
		this.userAddr3 = userAddr3;
		this.regDate = regDate;
		this.verify = verify;
	}
	
	
}
