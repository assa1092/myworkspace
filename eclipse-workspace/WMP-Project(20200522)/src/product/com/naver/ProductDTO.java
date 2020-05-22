package product.com.naver;

import java.io.Serializable;

public class ProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pid;
	private String pname;
	private int amount;
	private int price;
	private int discount;
	private String sid;

	public ProductDTO() {
	}

	public ProductDTO(String pid, String pname, int amount, int price, int discount, String sid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.amount = amount;
		this.price = price;
		this.discount = discount;
		this.sid = sid;
	}

	public ProductDTO(String mid) {
		super();

		this.sid = sid;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
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
		ProductDTO other = (ProductDTO) obj;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "===============================\n" + pid + "\n" + "제품명 : " + pname + "\n" + "수량 : " + amount + "개"
				+ "\n" + "보관중인 창고 아이디 : " + sid + "\n" + "총 가격 : " + (price - (price * discount) / 100) + "원"
				+ "\n===============================\n";

	}

}
