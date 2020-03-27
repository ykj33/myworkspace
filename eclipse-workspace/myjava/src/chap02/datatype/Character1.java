package chap02.datatype;

public class Character1 {
	public static void main(String[] args) {
		// 2byte 크기
		// 0 ~ 65535, 문자이기에 음수는 필요 없다.
		char c;
		c = 'A'; // 코드는 65
		System.out.println(c);
		c = '\u0041'; //  역슬래쉬u 코드로 쓰기, 41은 1바이트이므로 앞에 00붙여주기
		System.out.println(c);
		
		c = '\uAC00'; // 대소문자 구분 X
		System.out.println(c);
		
		c = '\uac01';
		System.out.println(c);
		
		int i = c;
		System.out.println(i);
	}
}
