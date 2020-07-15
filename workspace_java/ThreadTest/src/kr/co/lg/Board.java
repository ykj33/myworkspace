package kr.co.lg;

public class Board {
	private String content;
	boolean isOk = false;

	public String getContent() {
		if (!isOk) {
			// try-catch�� ����, wait�� ����ȭ������ ����� �Ѵ�.
			try {
				synchronized (this) {
					// �����Ͱ� �ö�� ������ ��� ��
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
