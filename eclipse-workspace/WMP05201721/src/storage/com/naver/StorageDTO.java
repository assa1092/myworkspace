package storage.com.naver;

public class StorageDTO {
	private String sid;
	private String location;
	private String stype;
	private String mid;

	public StorageDTO() {

	}

	public StorageDTO(String sid, String location, String stype, String mid) {
		super();
		this.sid = sid;
		this.location = location;
		this.stype = stype;
		this.mid = mid;
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

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
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
		StorageDTO other = (StorageDTO) obj;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "===============================\n" + sid + "\n위치 : " + location + "\n관리 품목 : " + stype + "\n관리자 : "
				+ mid + "\n===============================\n";
	}

}
