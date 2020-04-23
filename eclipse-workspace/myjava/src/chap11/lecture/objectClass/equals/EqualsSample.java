package chap11.lecture.objectClass.equals;

class TV {
	int type;

	@Override
	public boolean equals(Object obj) {
		// obj를 TV로 강제 형변환
		TV tv = (TV) obj;
		// 파라미터로 받은 타입과 필드값이 같으면 같다.
		return this.type == tv.type;
	}
}

public class EqualsSample {
	public static void main(String[] args) {
		TV tv1 = new TV();
		TV tv2 = new TV();
		tv1.type = 3;
		tv2.type = 3;
		// 참조값 비교
		System.out.println(tv1 == tv2);
		// 논리적으로 같은가
		// 같은 타입이면 같다고 판단하기로 재정의했기에 true
		System.out.println(tv1.equals(tv2));
	}
}
