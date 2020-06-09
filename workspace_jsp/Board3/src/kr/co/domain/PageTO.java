package kr.co.domain;

import java.util.List;

public class PageTO {
	// 현재 페이지
	private int curPage = 1;

	// 1페이지에 보여주는 게시글의 수
	private int perPage = 10;

	// 1페이지에 보여줄 수 있는 페이지 번호의 수
	private int pageLine = 10;

	// 게시글의 총 개수 count함수를 통해 가져옴
	private int amount;

	// 페이지의 총 개수 // amount와 curPage에 의해 종속되어 있음
	private int totalPage;

	// rownum값을 뜻함 curPage에 의해 종속, 게시글 관련
	private int startNum;

	// rownum값을 뜻함 curPage에 의해 종속, 게시글 관련
	private int endNum;

	// 시작하는 페이지 번호 curPage에 의해 결정된다. 종속변수
	private int beginPageNum;

	// 끝나는 페이지 번호 curPage에 의해 결정된다. 종속변수
	private int stopPageNum;

	// 페이지가 들어갈 수 있는 리스트
	private List<BoardDTO> list;

	public PageTO() {
		// curPage는 1이므로 종속변수들이 바뀐다.
		changeVarVal();
	}

	public PageTO(int curPage) {
		super();
		this.curPage = curPage;
		// curPage가 1이 아니어도 바뀌어야 한다.
		changeVarVal();
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
		// curPage가 바뀌면 종속변수들도 바뀌어야 한다.
		changeVarVal();
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
		// 종속변수가 아니므로 바뀌면 메소드가 호출되어야 함
		changeVarVal();
	}

	public int getPageLine() {
		return pageLine;
	}

	public void setPageLine(int pageLine) {
		this.pageLine = pageLine;
//		종속변수가 아니므로 바뀌면 메소드가 호출되어야 함
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
		// 이런 식도 가능
//		totalPage = (amount - 1) / perPage + 1;

		totalPage = amount / perPage;
		if (amount % perPage != 0) {
			totalPage = totalPage + 1;
		}

		// startnum은 curpage에 종속된다.
		startNum = (curPage - 1) * perPage + 1;
		endNum = curPage * perPage;
		// 총 게시글의 수가 27, endNum = 30이면 성립되지 않으므로 바꿔주어야 한다.
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
