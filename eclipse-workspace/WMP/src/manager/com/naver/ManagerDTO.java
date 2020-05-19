package manager.com.naver;

import java.io.Serializable;

public class ManagerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mid;
	private String mname;
	private String dept;
	

	public ManagerDTO() {
		// TODO Auto-generated constructor stub
	}

	public ManagerDTO(String mid, String mname, String dept) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.dept = dept;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
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
		ManagerDTO other = (ManagerDTO) obj;
		if (mid == null) {
			if (other.mid != null)
				return false;
		} else if (!mid.equals(other.mid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "===============================\n" + mid + "\n" + "이름   : " + mname + "\n" + "부서   : " + dept + "\n"
				+ "\n===============================\n";
	}

}
