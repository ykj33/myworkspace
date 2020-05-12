package com.naver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test1 {
	public void me1(int a) {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(0);
		set1.add(0);
		set1.add(1);
		set1.add(1);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		set1.add(5);

		System.out.println(set1.size());
		System.out.println(set1);

		Iterator<Integer> it = set1.iterator();
		while (it.hasNext()) { // 다음에 데이터가 있는가? 있으면 true
			Integer value = it.next(); // 다음 데이터로 옮긴다.
			System.out.println(value);

		}
	}

	public void me2(Pear p) {
		Set<String> set2 = new HashSet<String>();
		set2.add("hello");
		set2.add("world");
		set2.add("hello");
		set2.add(new String("world")); // 참조자료형은 동등성 비교를 하기 때문에 중복이므로 적용되지 않는다.
		set2.add("good");
		set2.add("morning");
		set2.add(new String("good"));

		System.out.println(set2.size());
		System.out.println(set2);

		Iterator<String> it = set2.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println(value);

		}
		ArrayList<String> list2 = new ArrayList<String>(set2);
		System.out.println(list2); // 이렇게 넣어도 되지만 me3에서 사용한 방법이 더 자주 사용된다.
	}

	public void me3(List<Integer> list) {
		Set<Apple> set3 = new HashSet<Apple>();
		set3.add(new Apple("사과1", 3000));
		set3.add(new Apple("사과2", 3500));
		set3.add(new Apple("사과3", 2000));
		set3.add(new Apple("사과1", 3000));
		set3.add(new Apple("사과2", 1000));

		System.out.println(set3.size());
		System.out.println(set3);

		Iterator<Apple> it = set3.iterator();
		ArrayList<Apple> list3 = new ArrayList<Apple>(); // value 값은 while문 내에서만 사용 가능하므로 밖에서 먼저 선언한다.
		while (it.hasNext()) {
			Apple apple = it.next();
			System.out.println(apple.getName());
			System.out.println(apple.getPrice());
			list3.add(apple); // list3에 값을 넣어준다. while문 밖에서도 사용할 수 있게됨
		}
		System.out.println(list3);

	}

	public void me4() {
		HashSet<Integer> set4 = new HashSet<Integer>();
		set4.add(1);
		set4.add(11);
		set4.add(121);
		set4.add(111);
		set4.add(101);
		set4.add(14);
		System.out.println(set4);
		set4.remove(14); // 인덱스가 없으므로 객체를 직접 넣어주어야 한다.
		System.out.println(set4);

		set4.clear(); // 초기화
	}
}
