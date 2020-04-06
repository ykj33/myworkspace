package chap06.examples.sec060801;

public class ComputerExample {
	public static void main(String[] args) {
		Computer myCom = new Computer();
		// 배열을 넣어주어야한다.
		int[] values1 = { 1, 2, 3 };
		int result1 = myCom.sum1(values1);
		System.out.println("result1 : " + result1);

		int result2 = myCom.sum1(new int[] { 1, 2, 3, 4, 5 });
		System.out.println("result2 : " + result2);
// int리스트를 넣어주어야 한다. 배열을 넣어서 써주는 것도 가능
		int result3 = myCom.sum2(1, 2, 3);
		System.out.println("result3 : " + result3);

		int result4 = myCom.sum2(1, 2, 3, 4, 5);
		System.out.println("result4 : " + result4);
		myCom.sum2(new int[] { 1, 2, 3 });
	}
}
