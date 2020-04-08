package chap06.exercises.ex14;

public class Member {
	private String name;
	private String id;
	private String password;
	private int age;
	// boolean 타입은 get, is 둘 다 사용 가능
	private boolean stop;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
}
