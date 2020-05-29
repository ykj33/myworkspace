package com.naver;

public class CommandAction {

	// 포워딩 방식이 무엇인가?
	private boolean isRedirect;
	// 어디로 가는가?
	private String where;

	public CommandAction() {
		// TODO Auto-generated constructor stub
	}

	public CommandAction(boolean isRedirect, String where) {
		super();
		this.isRedirect = isRedirect;
		this.where = where;
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

}
