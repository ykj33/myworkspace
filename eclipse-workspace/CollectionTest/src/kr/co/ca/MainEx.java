package kr.co.ca;

import java.util.ArrayList;
import java.util.List;

import com.naver.Test1;

public class MainEx {
	public static void main(String[] args) {
		// 괄호 안이 제네릭 Generic
		// Generic : 자바 컬렉션 프레임워크 상자(객체)에 들어갈 수 있는 요소(객체)의 자료형을 규정하는 문법
		List<StringBuffer> list = new ArrayList<StringBuffer>();
//		List<Apple> appleBox = new ArrayList<Apple>();
		List<Pear> pearBox = new ArrayList<Pear>();

		// 기본자료 형의 첫 글자가 대문자 - Wrapper 클래스
		// 기본자료 형은 객체가 될 수 없지만 Wrapper 클래스를 이용하면 객체 생성 가능
		// 기본자료 형으로도 컬렉션 프레임워크 사용 가능
		GTest<Long> gt1 = new GTest<Long>();
		GTest<Boolean> gt2 = new GTest<Boolean>();
		GTest<Byte> gt3 = new GTest<Byte>();
		GTest<Short> gt4 = new GTest<Short>();
		GTest<Float> gt5 = new GTest<Float>();
		GTest<Double> gt6 = new GTest<Double>();
		GTest<Character> gt7 = new GTest<Character>();
		GTest<Integer> gt8 = new GTest<Integer>();

		// Wrapper 클래스를 통해 가능함
		// autoboxing - 자동으로 객체화, autounboxing - 자동으로 기본자료형화
		int a = new Integer(4); // autounboxing
		int b = new Integer(4).intValue(); // 원래는 이렇게 해야 했다.
		Integer c = 4; // autoboxing
		System.out.println(a);

		String str = "55";
		int d = 55;

		System.out.println(str);
		System.out.println(d);
		System.out.println(str + d);
		int s = Integer.parseInt(str);
		System.out.println(s + d);

		String str2 = "C";
		// String을 char로 바꿀 때에는 parseChar가 아닌 charAt()메소드를 사용한다.
		char e = str2.charAt(0);

//		s=Integer.valueOf(i); valueOf를 사용하면 parse~~를 대체할 수 있으나 잘 사용하지 않는다.
		System.out.println("======================");
		Test1 t1 = new Test1();
		t1.me6();
		System.out.println("======================");
		t1.me5();
		System.out.println("======================");
		t1.me4();
		System.out.println("======================");
		// 파라미터로 List<String>을 받기 때문에 객체를 생성하여 파라미터 값으로 넣어주어야 한다.
		List<String> list3 = new ArrayList<String>();
		t1.me3(list3);
		System.out.println("======================");
		t1.me2();
		System.out.println("======================");
		t1.me7();
		System.out.println("======================");
		t1.me8();
		System.out.println("======================");
		t1.me9();
		System.out.println("======================");
		t1.me10();
		System.out.println("======================");
		t1.me11();
	}
}
