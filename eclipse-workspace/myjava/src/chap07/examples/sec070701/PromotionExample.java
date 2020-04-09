package chap07.examples.sec070701;

class A {
}

class B extends A {
}

class C extends A {
}

class D extends B {
}

class E extends C {
}

public class PromotionExample {

	B b = new B();
	C c = new C();
	D d = new D();
	E e = new E();

	A a1 = b;
	A a2 = c;
	A a3 = d;
	A d4 = e;

	B b1 = d;
	C c1 = e;

	// 상속관계가 아니기 때문에 되지 않는다.
	// B b3 = e;
	// C c2 = d;
}
