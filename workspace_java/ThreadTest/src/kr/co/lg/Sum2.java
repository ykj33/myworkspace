package kr.co.lg;

public class Sum2 {
	public int num1;
	
	public int num2;
	
	public int num3;
	
	Object key1 = new Object();
	Object key2 = new Object();
	
	
	// ���� ���� �����Ϳ��Դ� ���� Ű�� �־�� ��
	public void subNum1(int n) {
		synchronized (this) {
			num1 = num1 - n;
		}
	}
	 
	public void subNum2(int n) {
		synchronized (key1) {
			num2 = num2 - n;
		}
	}
	
	public void addNum1(int n) {
		// surround with�� ����ȭ ������ ����
		// this�� �ڱ� �ڽ�
		synchronized (this) {
			num1 = num1 + n;
		}
	}
	
	public void addNum2(int n) {
		
		// ���ο� ���踦 ����� ����� �� �ְ� ���ش�.
		// this�ʹ� �ٸ��� ������ �������.
		synchronized (key1) {
			num2 = num2 + n;
		}
	}
	
public void addNum3(int n) {
		
		// ���ο� ���踦 ����� ����� �� �ְ� ���ش�.
		// this�ʹ� �ٸ��� ������ �������.
		synchronized (key2) {
			num3 = num3 + n;
		}
	}
}
