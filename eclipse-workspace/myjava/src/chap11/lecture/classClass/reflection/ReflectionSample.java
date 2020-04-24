package chap11.lecture.classClass.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class MyClass {
	public int i;
	private int j;

	public MyClass() {

	}

	public MyClass(int i) {
	}

	public void method1() {

	}

	private int method2() {
		return 0;
	}
}

public class ReflectionSample {
	public static void main(String[] args) {
		Class c1 = MyClass.class;
		// 생성자 타입 배열을 반환
		// public 생성자만 가져옴
		c1.getConstructors();
		// 모든 생성자를 가져옴
		Constructor[] cons = c1.getDeclaredConstructors();
		for (Constructor con : cons) {
			System.out.println(con.getName());
		}
		// 필드 타입 배열 반환, 필드에 대한 정보를 얻을 수 있음
		Field[] fields = c1.getDeclaredFields();
		for (Field f : fields) {
			System.out.println(f.getName());
		}

		Method[] methods = c1.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m.getName());
		}
	}
}
