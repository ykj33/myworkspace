package chap02.datatype;

public class Long1 {
public static void main(String[] args) {
	// 8byte 크기
	// -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
	
	long l;
	l = 2147483647;
	l = 2147483648L; // integer타입의 저장범위를 넘어서는 수는 컴파일 할 수 없다. 따라서 뒤에 L을 붙여 long타입이라는 것을 선언해야 함
	l = 3000000000L;
	l = 3000000000l; // 1로 보일 수 있기에 권장 X
	System.out.println(l);
	
	
}
}
