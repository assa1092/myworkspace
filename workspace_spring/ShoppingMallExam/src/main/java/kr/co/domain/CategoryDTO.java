package kr.co.domain;

public class CategoryDTO {
	
	private String categoryName;
	private int categoryNo;
	private int categoryNoRef;
	private int categoryDegree;
	private String categoryEngName;
	
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDTO(String categoryName, int categoryNo, int categoryNoRef, int categoryDegree,
			String categoryEngName) {
		super();
		this.categoryName = categoryName;
		this.categoryNo = categoryNo;
		this.categoryNoRef = categoryNoRef;
		this.categoryDegree = categoryDegree;
		this.categoryEngName = categoryEngName;
	}

	
	public String getCategoryEngName() {
		return categoryEngName;
	}

	public void setCategoryEngName(String categoryEngName) {
		this.categoryEngName = categoryEngName;
	}

	public int getCategoryDegree() {
		return categoryDegree;
	}

	public void setCategoryDegree(int categoryDegree) {
		this.categoryDegree = categoryDegree;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public int getCategoryNoRef() {
		return categoryNoRef;
	}

	public void setCategoryNoRef(int categoryNoRef) {
		this.categoryNoRef = categoryNoRef;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryNo;
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
		CategoryDTO other = (CategoryDTO) obj;
		if (categoryNo != other.categoryNo)
			return false;
		return true;
	}
	
	
}
