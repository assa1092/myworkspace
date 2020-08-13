package kr.co.domain;

import java.sql.Date;

public class SearchDTO {
	private int categoryNo;
	private Date[] regDate;
	private int minPrice;
	private int maxPrice;
	private String searchType;
	private String keyWord;
	private int[] sellStatus;
	private int[] isDelete;
	
	public SearchDTO() {
		// TODO Auto-generated constructor stub
	}

	public SearchDTO(int categoryNo, Date[] regDate, int minPrice, int maxPrice, String searchType, String keyWord,
			int[] sellStatus, int[] isDelete) {
		super();
		this.categoryNo = categoryNo;
		this.regDate = regDate;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.searchType = searchType;
		this.keyWord = keyWord;
		this.sellStatus = sellStatus;
		this.isDelete = isDelete;
	}



	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public Date[] getRegDate() {
		return regDate;
	}

	public void setRegDate(Date[] regDate) {
		this.regDate = regDate;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public int[] getSellStatus() {
		return sellStatus;
	}

	public void setSellStatus(int[] sellStatus) {
		this.sellStatus = sellStatus;
	}

	public int[] getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int[] isDelete) {
		this.isDelete = isDelete;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}	
	
	
}
