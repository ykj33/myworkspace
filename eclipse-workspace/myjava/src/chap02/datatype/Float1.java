package chap02.datatype;

public class Float1 {
public static void main(String[] args) {
	// 4byte 크기
	
	// 최대값 (3.4028235E38)
	System.out.println(Float.MAX_VALUE);
	// 최소값 (1.4E-45)
	System.out.println(Float.MIN_VALUE);
	
	float f;
	f = 3.14F; // JAVA는 기본적으로 double로 생각하기 때문에 F를 붙여 float 타입이라는 것을 표시해야 함
	f = 3.14f; // 권장 X
	
	System.out.println(f);
	
}
}
