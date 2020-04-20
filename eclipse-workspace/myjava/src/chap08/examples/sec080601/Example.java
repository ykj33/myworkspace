package chap08.examples.sec080601;

public class Example {
	public static void main(String[] args) {
		ImplementationC impl = new ImplementationC();

		// Im~은 구현클래스이고, C가 A, B를 다 상속받았기 때문에 가능
		System.out.println(impl instanceof ImplementationC);
		System.out.println(impl instanceof InterfaceA);
		System.out.println(impl instanceof InterfaceB);
		System.out.println(impl instanceof InterfaceC);

		InterfaceA ia = impl;
		ia.methodA();
		System.out.println();

		InterfaceB ib = impl;
		ib.methodB();
		System.out.println();

		InterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}
}
