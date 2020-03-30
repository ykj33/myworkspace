package chap02.examples;

public class FromIntToFloat {
public static void main(String[] args) {
	int num1 = 123456780;
	int num2 = 123456780;
	
	float num3 = num2;
	num2 = (int) num3;
	
	// float 지수(8비트)가수(23비트)
	// double 지수(11비트)가수(52비트)
	// int(32비트)
	int result = num1 - num2;
	System.out.println(result);
}
}
