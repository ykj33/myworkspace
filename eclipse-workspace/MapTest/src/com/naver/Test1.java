package com.naver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test1 {

	// Map을 통해 DTO 클래스를 만들 필요를 없앤다.
	// 바로 값을 넣어도 됨
	public void me1() {
		// 보통 키 값으로는 String, 키는 중복되면 안되므로 내부적으로 Set으로 관리되고 있음
		Map<String, String> map1 = new HashMap<String, String>();
	}

	public void me2() {
		Map<Pear, Apple> map2 = new HashMap<Pear, Apple>();
	}

	public void me3() {
		Map<Integer, String> map3 = new HashMap<Integer, String>();
		map3.put(1, "hello");
		map3.put(101, "hello"); // 키값은 순서를 지킬 필요가 없다.
		map3.put(1, "world"); // Map에서 키 값이 중복되면 새롭게 수정된 것으로 생각한다.
		map3.put(2, "!!!!");
		System.out.println(map3);
		Set<Integer> s = map3.keySet();
		Iterator<Integer> it = s.iterator();
		ArrayList<String> list = new ArrayList<String>();
		while (it.hasNext()) {
			Integer key = it.next();
			String value = map3.get(key);
			System.out.println("======================");
			System.out.println(value);
			list.add(value);
		}
		System.out.println("======================");
		System.out.println(list);
	}

	public void me4() {
		Map<String, Integer> map4 = new HashMap<String, Integer>();
		map4.put("hello", 1);
		map4.put("world", 2);
		map4.put("good", 3);
		map4.put("morning", 4);

		int a = map4.get("hello");
		System.out.println(a);
		Set<String> s = map4.keySet();
		Iterator<String> it = s.iterator();
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (it.hasNext()) {
			String key = it.next();
			Integer value = map4.get(key);
			System.out.println("====================== me4");
			System.out.println(value);
			list.add(value);
		}
		System.out.println("======================");
		System.out.println(list);
	}

	public void me5() {
		Map<String, Apple> map5 = new HashMap<String, Apple>();

		map5.put("부산", new Apple("부사", 2000));
		map5.put("대구", new Apple("홍옥", 3000));
		map5.put("대전", new Apple("왕사과", 4000));
		map5.put("서울", new Apple("부사", 1000));
		Set<String> s = map5.keySet(); // keySet으로 키들의 목록을 뽑을 수 있다.
		Iterator<String> it = s.iterator(); // iterator를 사용하여 값 출력하기
		ArrayList<Apple> apple = new ArrayList<Apple>(); // while문 밖에서 변수를 선언하여 외부에서도 사용할 수 있게 한다.
		while (it.hasNext()) {
			String key = it.next();
			Apple value = map5.get(key); // key에 넣은 키 값을 Apple 타입 value에 넣어준다.
			System.out.println(value.getName());
			System.out.println(value.getPrice());
			apple.add(value);
		}
		System.out.println("======================");
		System.out.println(apple);
	}
}
