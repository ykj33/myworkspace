package chap11.examples.sec110304;

public class MemberExample {
	public static void main(String[] args) {
		// 원본 객체 생성
		Member original = new Member("blue", "홍길동", "12345", 25, true);

		// 복제 객체를 얻은 후에 패스워드 변경
		Member cloned = original.getMember();
		// 복제 객체에서 패스워드 변경
		cloned.password = "67890";

		System.out.println("[복제 객체의 필드값]");
		System.out.println("id : " + cloned.id);
		System.out.println("name : " + cloned.name);
		System.out.println("password : " + cloned.password);
		System.out.println("age : " + cloned.age);
		System.out.println("adult : " + cloned.adult);

		System.out.println();

		System.out.println("[원본 객체의 필드값]");
		System.out.println("id : " + original.id);
		System.out.println("name : " + original.name);
		// 얕은 복제이기 때문에 복제 객체의 필드값을 변경하더라도 참조하는건 원본 객체이기에 변함 없음
		System.out.println("password : " + original.password);
		System.out.println("age : " + original.age);
		System.out.println("adult : " + original.adult);

	}
}
