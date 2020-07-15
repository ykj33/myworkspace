package kr.co.lg;

public class Board {
	private String content;
	boolean isOk = false;

	public String getContent() {
		if (!isOk) {
			// try-catch로 묶고, wait를 동기화블럭으로 묶어야 한다.
			try {
				synchronized (this) {
					// 데이터가 올라올 때까지 대기 중
					wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		isOk = true;

		synchronized (this) {
			notifyAll();
		}
	}
}
