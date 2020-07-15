package kr.co.lg;

public class Sum2 {
	public int num1;
	
	public int num2;
	
	public int num3;
	
	Object key1 = new Object();
	Object key2 = new Object();
	
	
	// 같은 공유 데이터에게는 같은 키를 주어야 함
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
		// surround with로 동기화 블럭으로 만듦
		// this는 자기 자신
		synchronized (this) {
			num1 = num1 + n;
		}
	}
	
	public void addNum2(int n) {
		
		// 새로운 열쇠를 만들어 사용할 수 있게 해준다.
		// this와는 다르기 때문에 상관없다.
		synchronized (key1) {
			num2 = num2 + n;
		}
	}
	
public void addNum3(int n) {
		
		// 새로운 열쇠를 만들어 사용할 수 있게 해준다.
		// this와는 다르기 때문에 상관없다.
		synchronized (key2) {
			num3 = num3 + n;
		}
	}
}
