package kr.co.lg;

public class MyThread extends Thread {
	public SyncTest st;

	public MyThread() {
		// TODO Auto-generated constructor stub
	}

	public MyThread(SyncTest st) {
		super();
		this.st = st;
	}

	@Override
	public void run() {
		st.addNum();
	}
}
