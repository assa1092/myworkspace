package kr.co.domain;

public class GoodsDTO {
	
	/*
	 * 
	create table goods (
   		goodsNum       number          not null,
	    goodsName      varchar2(50)    not null,
	    cateCode     varchar2(30)    not null,
	    goodsPrice     number          not null,
    	goodsStock     number          null,
	    goodsDes       varchar(500)    null,
    	goodsImg       varchar(200)    null,
	    goodsDate      date            default sysdate,
	    primary key(goodsNum)  
	);
	 * 
	 * */
	
	private int goodsNum;		//상품 번호
	private String goodsName;	// 상품 이름
	private String cateCode;	// 상품 분류
	private int goodsPrice;		// 가격
	private int goodsStock; 	// 수량
	private String goodsDes;	// 설명
	private String goodsImg; 	// 이미지
	private String goodsDate;   // 등록날짜.
	
	public GoodsDTO() {
		// TODO Auto-generated constructor stub
	}

	public GoodsDTO(int goodsNum, String goodsName, String cateCode, int goodsPrice, int goodsStock, String goodsDes,
			String goodsImg, String goodsDate) {
		super();
		this.goodsNum = goodsNum;
		this.goodsName = goodsName;
		this.cateCode = cateCode;
		this.goodsPrice = goodsPrice;
		this.goodsStock = goodsStock;
		this.goodsDes = goodsDes;
		this.goodsImg = goodsImg;
		this.goodsDate = goodsDate;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getGoodsStock() {
		return goodsStock;
	}

	public void setGoodsStock(int goodsStock) {
		this.goodsStock = goodsStock;
	}

	public String getGoodsDes() {
		return goodsDes;
	}

	public void setGoodsDes(String goodsDes) {
		this.goodsDes = goodsDes;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public String getGoodsDate() {
		return goodsDate;
	}

	public void setGoodsDate(String goodsDate) {
		this.goodsDate = goodsDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + goodsNum;
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
		GoodsDTO other = (GoodsDTO) obj;
		if (goodsNum != other.goodsNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GoodsDTO [goodsNum=" + goodsNum + ", goodsName=" + goodsName + ", cateCode=" + cateCode
				+ ", goodsPrice=" + goodsPrice + ", goodsStock=" + goodsStock + ", goodsDes=" + goodsDes + ", goodsImg="
				+ goodsImg + ", goodsDate=" + goodsDate + "]";
	}
	
	

}
