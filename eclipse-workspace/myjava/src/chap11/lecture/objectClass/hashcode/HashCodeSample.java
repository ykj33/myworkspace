package chap11.lecture.objectClass.hashcode;

class Book {
	int isbn;

	@Override
	public int hashCode() {
		// 재정의해서 사용해야 함.
		// equals로 같게 만들었으면 해쉬코드도 같아야 함.
		// 재정의하기 전까지는 그냥 참조값에 지나지 않으므로 재정의 필요
		return this.isbn;
	}

	@Override
	public boolean equals(Object obj) {
		Book o = (Book) obj;
		return this.isbn == o.isbn;
	}
}

public class HashCodeSample {
	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book();
		b1.isbn = 3;
		b2.isbn = 3;
		System.out.println(b1.equals(b2));
		System.out.println(b1.hashCode());
		System.out.println(b2.hashCode());
	}
}
