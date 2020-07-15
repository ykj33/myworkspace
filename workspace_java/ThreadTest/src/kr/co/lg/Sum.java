package kr.co.lg;

public class Sum {
	public int num1;

	// 동기화메소드로 묶어주면 동기화 문제를 해결할 수 있다.
	
	public synchronized void addNum1(int n) {
		num1 = num1 + n;
	}
}
