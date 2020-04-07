package chap06.examples.sec060804;

public class CalculatorExample {
	public static void main(String[] args) {
		Calculator myCalcu = new Calculator();

		// 정사각형의 넓이 구하기
		double result1 = myCalcu.areaRectangle(10);

		// 직사각형의 넓이 구하기
		double result2 = myCalcu.areaRectangle(10, 20);

		System.out.println("정사격형의 넒이 = " + result1);
		System.out.println("직사각형의 넓이 = " + result2);
	}
}
