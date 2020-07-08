package kr.co.domain;

import java.util.List;

// 제네릭으로 선언
public class PageTO<T> {
	// 현재 페이지
	private int curPage = 1;
	// 한 페이지에 게시물 10개 씩
	private int perPage = 10;
	// 한 줄에 10페이지
	private int pageLine = 10;
	// 게시물의 개수
	private int amount;
	// 게시물의 총 개수
	private int totalPage;
	// 시작하는 페이지의 rownum
	private int startNum;
	// 끝나는 페이지의 rownum
	private int endNum;
	// foreach 문의 begin값, 페이지 번호의 첫 번호
	private int beginPageNum;
	// foreach 문의 end 값 페이지 번호의 끝 번호
	private int stopPageNum;

	// 제네릭을 사용
	private List<T> list;

	public PageTO() {
		executeAll();
	}

	public PageTO(int curPage) {
		super();
		this.curPage = curPage;
		// 계속 바뀌므로 바뀐 값을 넣어서 실행시켜야 한다.
		executeAll();
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
		// 계속 바뀌므로 바뀐 값을 넣어서 실행시켜야 한다.
		executeAll();
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
		// 계속 바뀌므로 바뀐 값을 넣어서 실행시켜야 한다.
		executeAll();
	}

	public int getPageLine() {
		return pageLine;
	}

	public void setPageLine(int pageLine) {
		this.pageLine = pageLine;
		// 계속 바뀌므로 바뀐 값을 넣어서 실행시켜야 한다.
		executeAll();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		// 계속 바뀌므로 바뀐 값을 넣어서 실행시켜야 한다.
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

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	private void executeAll() {
		// 직접 계산해보자.
		totalPage = (amount - 1) / perPage + 1;

		startNum = (curPage - 1) * perPage + 1;

		endNum = curPage * perPage;
		if (endNum > amount) {
			endNum = amount;
		}

		beginPageNum = ((curPage - 1) / pageLine) * pageLine + 1;
		stopPageNum = beginPageNum + (pageLine - 1);
		if (stopPageNum > totalPage) {
			stopPageNum = totalPage;
		}
	}
}
