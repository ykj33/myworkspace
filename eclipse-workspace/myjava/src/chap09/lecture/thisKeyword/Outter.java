package chap09.lecture.thisKeyword;

public class Outter {
	int outterF;
	int sameF;

	class Nested {
		int nestedF;
		int sameF;

		void method() {
			System.out.println(nestedF);
			System.out.println(outterF);
			// 필드의 이름이 같으면 가장 가까운 필드를 지칭한다.
			System.out.println(sameF);
			System.out.println(this.sameF);
			// this를 그냥 쓰면 해당 클래스, 바깥 클래스 명을 같이 쓰면 바깥 클래스의 인스턴스를 의미
			System.out.println(Outter.this.sameF);
		}
	}
}
