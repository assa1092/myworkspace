package review;

import java.io.Serializable;

public class uploadDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileName;
	private String orgFileName;
	private int num;
	
	public uploadDTO() {
		// TODO Auto-generated constructor stub
	}

	public uploadDTO(String fileName, String orgFileName, int num) {
		super();
		this.fileName = fileName;
		this.orgFileName = orgFileName;
		this.num = num;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + num;
		result = prime * result + ((orgFileName == null) ? 0 : orgFileName.hashCode());
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
		uploadDTO other = (uploadDTO) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (num != other.num)
			return false;
		if (orgFileName == null) {
			if (other.orgFileName != null)
				return false;
		} else if (!orgFileName.equals(other.orgFileName))
			return false;
		return true;
	}

	
	

}
