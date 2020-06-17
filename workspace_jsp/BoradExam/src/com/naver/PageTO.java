package com.naver;

import java.util.List;

public class PageTO {
	private int curPage = 1;	// 일단은 첫페이지로..
	private int perPage = 10;	// 한페이지당 10개씩 보여준다는 의미.
	private int pageLine = 10;	// 하단에 페이지 숫자 보여주는것...10개씩.. 총 15페이지이면 마지막에는 11, 12, 13, 14, 15 까지만...
	private int amount ;		// 게시글의 총개수...
	private int totalPage;		// 총 페이지수..curPage, amount 의해 정해진다..종속변수
	private int startNum;		// oracle에서의 rownum값 넣어준다...1~...curPage 의해 정해진다..종속변수...
	private int endNum;			// oracle에서의 rownum값 넣어준다...10
	private int beginPageNum;	// 1~10, 11~20	curPage에 의해서 보여줄 페이지가 정해진다...종속변수..
	private int stopPageNum;
	
	private List<BoardDTO> list;
	
	public PageTO() {
		changeVarVal();
	}

	public PageTO(int curPage) {
		super();
		this.curPage = curPage;
		changeVarVal();
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
		changeVarVal();
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
		changeVarVal();
	}

	public int getPageLine() {
		return pageLine;
	}

	public void setPageLine(int pageLine) {
		this.pageLine = pageLine;
		changeVarVal();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		changeVarVal();
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

	public List<BoardDTO> getList() {
		return list;
	}

	public void setList(List<BoardDTO> list) {
		this.list = list;
	}
	
	private void changeVarVal() {
		// 총페이지수... 총개수/
		totalPage = amount/perPage;		//	totalPage = (amount-1)/perPage +1; 이렇게도 씀.....
		if(amount % perPage != 0) {
			totalPage = totalPage +1;
		}
		// startNum : 게시글의 rownum 값
		startNum = (curPage -1)* perPage +1;
		// endNum : 
		endNum = curPage * perPage;		// endNum = startNum + pageLine 이렇게도 씀...
		if(endNum > amount) {
			endNum = amount;
			// 총 게시글의 수가 27
			// endNum = 30??? 아니라...endNum = 27로...한다..
		}
		
		beginPageNum = ((curPage - 1)/pageLine) * pageLine +1;
		stopPageNum = beginPageNum + (pageLine-1);
		if(stopPageNum > totalPage) {
			stopPageNum = totalPage;
		}
		
		
		
	}

}
