package chap02.datatype;

public class Byte1 {
	public static void main(String[] args) {

		// 1byte 크기 (8bit)
		// -128 ~ 127까지 표현 가능
		byte b;
		b = 127;
		System.out.println(b);
		// b= 128; 범위를 넘었기에 들어가지 않는다.
		b++;
		System.out.println(b); // overflow
		
		b = 0;
		b--;
		
		b= -128;
		b--;
		System.out.println(b); // underflow
	}
}
