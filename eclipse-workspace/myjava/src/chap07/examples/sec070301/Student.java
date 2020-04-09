package chap07.examples.sec070301;

public class Student extends People {
	public int studentNo;

	public Student(String name, String ssn, int studentNo) {
		super(name, ssn); // 사용하지 않아도 부모 클래스의 생성자를 꼭 호출해주어야 한다.
		this.studentNo = studentNo;
	}
}
