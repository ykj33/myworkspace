package kr.co.lg;

public class Sum {
	public int num1;

	// ����ȭ�޼ҵ�� �����ָ� ����ȭ ������ �ذ��� �� �ִ�.
	
	public synchronized void addNum1(int n) {
		num1 = num1 + n;
	}
}
