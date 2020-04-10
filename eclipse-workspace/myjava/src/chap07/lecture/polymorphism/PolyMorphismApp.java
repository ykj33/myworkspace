package chap07.lecture.polymorphism;

public class PolyMorphismApp {

	public static void sayCry(KindaCat c) {

	}

	public static void main(String[] args) {
		Tiger t = new Tiger();
		Cat c = new Cat();
		
		// 파라미터로 상위 클래스의 인스턴스를 받는 경우 하위 클래스의 인스턴스를 넣어줄 수 있음 
		sayCry(t);
		sayCry(c);
		sayCry(new Tiger());
		sayCry(new Cat());

		long[] larr = new long[3];
//		자동 타입 변환이 되어 int, long 다 넣을 수 있음
		larr[0] = 3;
		larr[1] = 98709979L;

		Tiger[] tarr = new Tiger[3];
		tarr[0] = new Tiger();
		tarr[1] = new Tiger();

		KindaCat[] karr = new KindaCat[3];
//		하위 인스턴스라면 배열로 관리가 가능하다
		karr[0] = new KindaCat();
		karr[1] = new Tiger();
		karr[2] = new Cat();

		t.cry();
		c.cry();

//		부모 클래스의 타입으로 바꿀 수 있다
		KindaCat c1 = t;
		KindaCat c2 = c;

		c1.cry();
		c2.cry();

//		역은 안된다.
//		t = c1;
//		c = c2;

	}
}
