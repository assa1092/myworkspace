package main.search;

import java.io.Serializable;

public class WmpDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mid;
	private String mname;
	private String dept;
	private String pid;
	private String pname;
	private int amount;
	private int price;
	private int discount;
	private String sid;
	private String location;
	private String stype;
	private int totalprice = (price - (price * discount) / 100);

	public WmpDTO() {
		// TODO Auto-generated constructor stub
	}

	public WmpDTO(String mid, String mname, String dept, String pid, String pname, int amount, int price, int discount,
			String sid, String location, String stype) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.dept = dept;
		this.pid = pid;
		this.pname = pname;
		this.amount = amount;
		this.price = price;
		this.discount = discount;
		this.sid = sid;
		this.location = location;
		this.stype = stype;
	}

	public WmpDTO(String pname, String stype, String location, int amount, int price) {
		super();
		this.pname = pname;
		this.amount = amount;
		this.price = price;
		this.location = location;
		this.stype = stype;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
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

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
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
		WmpDTO other = (WmpDTO) obj;
		if (mid == null) {
			if (other.mid != null)
				return false;
		} else if (!mid.equals(other.mid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " [mid=" + mid + ", mname=" + mname + ", dept=" + dept + ", pid=" + pid + ", pname=" + pname
				+ ", amount=" + amount + ", price=" + price + ", discount=" + discount + ", sid=" + sid + ", location="
				+ location + ", stype=" + stype + "]";
	}

}
