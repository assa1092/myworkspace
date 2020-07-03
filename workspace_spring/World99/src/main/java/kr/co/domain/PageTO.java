package kr.co.domain;

import java.util.List;

public class PageTO {
	private int curPage = 1;
	private int perPage = 10;
	private int pageLine = 10;
	private int amount;
	
	// 위의 변수들의 영향을 받는 종속변수
	private int totalPage;
	private int startNum;
	private int endNum;
	private int beginPageNum;
	private int stopPageNum;
	
	private List<BoardVO> list;
	
	public PageTO() {
		 executeAll();
	}
	
	
	
	public PageTO(int curPage) {
		super();
		this.curPage = curPage;
		executeAll();
	}
	



	public int getCurPage() {
		return curPage;
	}



	public void setCurPage(int curPage) {
		this.curPage = curPage;
		executeAll();
	}



	public int getPerPage() {
		return perPage;
	}



	public void setPerPage(int perPage) {
		this.perPage = perPage;
		executeAll();
	}



	public int getPageLine() {
		return pageLine;
	}



	public void setPageLine(int pageLine) {
		this.pageLine = pageLine;
		executeAll();
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
		executeAll();
	}



	public int getTotalPage() {
		return totalPage;
	}



	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}



	public int getStartNum() {
		return startNum;
	}



	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}



	public int getEndNum() {
		return endNum;
	}



	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}



	public int getBeginPageNum() {
		return beginPageNum;
	}



	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}



	public int getStopPageNum() {
		return stopPageNum;
	}



	public void setStopPageNum(int stopPageNum) {
		this.stopPageNum = stopPageNum;
	}



	public List<BoardVO> getList() {
		return list;
	}



	public void setList(List<BoardVO> list) {
		this.list = list;
	}



	// 디폴트 생성자, 종속변수를 제외한 다른 변수들의 setter에 추가...
	// 사용자 정의 생성자는 curPage만 가진 생성자로 만든다.
	private void executeAll() {
		
		totalPage = (amount-1)/perPage +1;
		
		startNum = (curPage-1)*perPage +1;
		endNum = curPage*perPage;
		if(endNum > amount) {
			endNum = amount;
		}
		
		beginPageNum = ((curPage-1)/pageLine)*pageLine+1;
		stopPageNum = beginPageNum + (pageLine-1);
		if (stopPageNum > totalPage) {
			stopPageNum = totalPage;
		}
	}
	
	

}
