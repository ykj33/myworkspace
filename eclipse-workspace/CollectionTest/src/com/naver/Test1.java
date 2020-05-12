package com.naver;

import java.util.ArrayList;
import java.util.List;

import kr.co.ca.Apple;
import kr.co.ca.Pear;

public class Test1 {
	public void me1() {
		List<Integer> list = new ArrayList<Integer>();

	}

	public void me2() {
		List<Apple> list2 = new ArrayList<Apple>();
		list2.add(new Apple("사과1", 3000));
		list2.add(new Apple("사과2", 3500));
		list2.add(new Apple("사과3", 2000));
		list2.add(new Apple("사과1", 3000));
		list2.add(new Apple("사과2", 1000));

		// 값을 줄여나가는 것도 필요하다.
		for (int i = list2.size() - 1; i >= 0; i--) {
			Apple aa = list2.get(i);
			System.out.println(aa.getName());
			System.out.println(aa.getPrice());
		}
		System.out.println("-------------------------");
		for (int i = 0; i < list2.size(); i++) {
			Apple a = list2.get(i);
			System.out.println(a.getName());
			System.out.println(a.getPrice());
			System.out.println("-------------------------");
		}
	}

	// list3을 받아 그대로 반환
	public List me3(List<String> list3) {
		list3.add("hello");
		list3.add("world");
		list3.add("good");
		list3.add("morning");
		list3.add("!!!!");

		for (int i = 0; i < list3.size(); i++) {
			String msg = list3.get(i);
			System.out.println(msg);

		}
		return list3;
	}

	public void me4() {
		List<Integer> list4 = new ArrayList<Integer>();
		// list에 데이터를 추가할 때는 add()메소드를 사용한다.
		list4.add(1);
		list4.add(2);
		list4.add(3);
		list4.add(5);
		list4.add(8);
		list4.add(11);
		for (int i = 0; i < list4.size(); i++) {
			System.out.println(list4.get(i));
		}
	}

	public void me5() {
		List<Apple> list5 = new ArrayList<Apple>();
		// List에 객체를 넣을 때는 제네릭으로 선언한 객체 생성 후 add()메소드를 통해 추가할 수 있다.
		// 참조자료형을 넣을 때 기억할 것
		Apple a1 = new Apple("부사", 2000);
		Apple a2 = new Apple("부사", 2500);
		Apple a3 = new Apple("알사과", 1000);

		list5.add(a1);
		list5.add(a2);
		list5.add(a3);
		// 일반적으로 이 방법을 주로 씀
		list5.add(new Apple("부사", 3000));
		list5.add(new Apple("홍옥", 1000));

		for (int i = 0; i < list5.size(); i++) {
			Apple a = list5.get(i);
			System.out.println("이름 : " + a.getName());
			System.out.println("가격 : " + a.getPrice());
			System.out.println("-------------------");
		}
	}

	public void me6() {
		List<Pear> list6 = new ArrayList<Pear>();
		list6.add(new Pear("배1", 3000));
		list6.add(new Pear("배2", 3500));
		list6.add(new Pear("배3", 2000));
		list6.add(new Pear("배1", 3000));
		list6.add(new Pear("배2", 1000));

		// get()메소드를 통해 값을 할당 할 수 있다.
		Pear p2 = list6.get(2);
		System.out.println(p2.getName());
		System.out.println(p2.getPrice());
		System.out.println("-------------------");
		// size()메소드를 통해 길이를 알 수 있고, for문을 돌려서 배열을 사용할 수 있다.
		for (int i = 0; i < list6.size(); i++) {
			Pear p = list6.get(i);
			System.out.println(p.getName());
			System.out.println(p.getPrice());

		}
		System.out.println("-------------------");
		// 향상된 for문
		for (Pear p : list6) {
			System.out.println(p.getName());
			System.out.println(p.getPrice());
		}
	}

	public void me7() {
		List<Integer> list7 = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list7.add(i * 2); // 짝수
		}
		// 0번 인덱스의 값을 1로 넣겠다.
		list7.set(0, 1);
		for (int i = list7.size() - 1; i >= 0; i--) {
			System.out.println(list7.get(i));
		}
	}

	public void me8() {
		List<Apple> list8 = new ArrayList<Apple>();
		list8.add(new Apple("부사", 1000));
		list8.add(new Apple("부사", 2000));
		list8.add(new Apple("홍옥", 3000));
		list8.add(new Apple("부사", 1000));

		int idx = list8.indexOf(new Apple("홍옥", 500));
		System.out.println(idx); // 해당되는 것이 없으므로 -1

		idx = list8.indexOf(new Apple("부사", 1000)); // 동일한 것이 있을 경우 앞에 있는 것부터 반환한다.
		System.out.println(idx);
	}

	public void me9() {
		List<Long> list9 = new ArrayList<Long>();

		list9.add(1L);
		list9.add(34L);
		list9.add(44L);

		for (int i = 0; i < list9.size(); i++) {
			long L = list9.get(i);
			System.out.println(L);
		}

		boolean b = list9.contains(34L); // 해당 객체가 포함되어 있는가?
		System.out.println(b);
	}

	public void me10() {
		List<Integer> list10 = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			list10.add(i * 21); // 21의 배수
		}
		for (int i = list10.size() - 1; i >= 0; i--) {
			System.out.println(list10.get(i));
		}
		System.out.println(list10);
		list10.remove(3); // 파라미터로 받은 값에 해당하는 인덱스 번호 값이 삭제된다.
		// 삭제될 경우 삭제된 곳을 메우면서 한칸씩 당겨진다. 그러므로 ArrayList를 이용해서 수정, 삭제를 하지 않는다.
		// LinkedList 사용
		System.out.println(list10);
		list10.remove(1); // 삭제는 뒤에서부터 삭제
		System.out.println(list10);
	}
	
	public void me11() {
		List<Integer> list11 = new ArrayList<Integer>();
		for(int i =0; i<10000; i++) {
			list11.add(i);
		}
		System.out.println(list11);
		list11.clear(); // 초기화한다.
	}
}
