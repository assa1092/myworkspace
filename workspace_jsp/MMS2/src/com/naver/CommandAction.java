package com.naver;

public class CommandAction {
	
	private boolean isRedirect;		// 포워딩 어떤걸로?
	private String where;			// 포워딩 어디로 갈껀지...
	
	public CommandAction() {
		// TODO Auto-generated constructor stub
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public CommandAction(boolean isRedirect, String where) {
		super();
		this.isRedirect = isRedirect;
		this.where = where;
	}
}
