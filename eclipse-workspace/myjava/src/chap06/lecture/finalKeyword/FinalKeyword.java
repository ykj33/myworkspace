package chap06.lecture.finalKeyword;

public class FinalKeyword {
	// 변수 앞에 붙으면 
	// 값을 할당할 기회를 한 번만 갖는다.
	final int i;
	
	
	FinalKeyword() {
		i = 90; // 생성자에서 값 할당 가능
	}
	void method(final int k) {
//		k = 90; // 호출 할 때 값을 부여하기 때문에 변경이 불가
		final int i;
		i = 30;
//		i = 29; // 2번 째 값을 넣을 수 없다.
		final int j = 60;
//		j = 70;
	}
}
