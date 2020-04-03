package chap05.examples;

public class ArrayCopyExample {
public static void main(String[] args) {
	// 그림 : 07 참조타입배열복사
	// 배열 복사 시 값 자체가 복사되는 것이 아니라 참조 값이 복사되는 것
	String[] oldStrArray = {"java","array","copy"};
	String[] newStrArray = new String[5];
	
	System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
	for(int i = 0; i<newStrArray.length;i++) {
		System.out.print(newStrArray[i] + ", ");
	}
}
}
