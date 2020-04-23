package chap11.examples.sec110304.deepCopy;

import java.util.Arrays;

public class Member implements Cloneable {
	public String name;
	public int age;
	public int[] scores;
	public Car car;

	public Member(String name, int age, int[] scores, Car car) {
		this.name = name;
		this.age = age;
		this.scores = scores;
		this.car = car;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 먼저 얕은 복사를 행서 name, age를 복제한다.
		Member cloned = (Member) super.clone(); // Object의 clone() 호출
		// scores를 깊은 복제한다.
		cloned.scores = Arrays.copyOf(this.scores, this.scores.length); // clone() 메소드 재정의
		// car를 깊은 복제한다.
		cloned.car = new Car(this.car.model);
		// 깊은 복제된 Member 객체를 리턴
		return cloned;
	}

	public Member getMemer() {
		Member cloned = null;
		try {
			cloned = (Member) clone(); // 재정의된 clone() 호출
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}
}
