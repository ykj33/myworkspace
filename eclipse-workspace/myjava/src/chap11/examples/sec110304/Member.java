package chap11.examples.sec110304;

public class Member implements Cloneable {
	public String id;
	public String name;
	public String password;
	public int age;
	public boolean adult;

	public Member(String id, String name, String password, int age, boolean adult) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.adult = adult;
	}

	public Member getMember() {
		Member cloned = null;
		try {
			// clone 메소드의 리턴 타입은 Object이므로 Member타입으로 캐스팅해야 함
			cloned = (Member) clone();
		} catch (CloneNotSupportedException e) {

		}
		return cloned;
	}
}
