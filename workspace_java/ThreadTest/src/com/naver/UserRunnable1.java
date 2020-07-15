package com.naver;

// runnable �������̽��� �����Ͽ� run() �޼ҵ� ���ο� ������ �ڵ� �ۼ�
public class UserRunnable1 implements Runnable {

	// my�� �����ص� null�� ��
	private Thread my;

	public UserRunnable1() {
		// TODO Auto-generated constructor stub
	}

	// �Ķ���ͷ� ���� my�� ����Ѵ�.
	public UserRunnable1(Thread my) {
		super();
		this.my = my;
	}

	@Override
	public void run() {

		// my �����尡 ���� ������ �Ʒ� �ڵ尡 ������� �ʴ´�.
		try {
			my.join();
		} catch (InterruptedException e1) {	
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
			char c = (char) (65 + i);
			System.out.println(c);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
